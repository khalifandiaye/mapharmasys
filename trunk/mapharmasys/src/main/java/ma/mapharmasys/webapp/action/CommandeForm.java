package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import ma.mapharmasys.Constants.TypeVente;
import ma.mapharmasys.model.Avance;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.model.LigneCommande;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.AvanceManager;
import ma.mapharmasys.service.ClientManager;
import ma.mapharmasys.service.CommandeManager;
import ma.mapharmasys.service.CreditManager;
import ma.mapharmasys.service.MedicamentManager;
import ma.mapharmasys.util.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("commandeForm")
@Scope("session")
public class CommandeForm extends BasePage implements Serializable {
	private CommandeManager commandeManager;
	private MedicamentManager medicamentManager;
	private ClientManager clientManager;
	private CreditManager creditManager;
	
	private Commande commande = new Commande();
	private Client client = new Client();
	private Credit credit = new Credit();
	private Avance avance = new Avance();
	
	private Medicament medicament = new Medicament();
	private boolean showClient = false;
	private int nbrMedicament = 1;
	private Long id;

	@Autowired
	public void setCommandeManager(
			@Qualifier("commandeManager") CommandeManager commandeManager) {
		this.commandeManager = commandeManager;
	}
	
	@Autowired
	public void setMedicamentManager(
			@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
		this.medicamentManager = medicamentManager;
	}
	
	@Autowired
	public void setClientManager(
			@Qualifier("clientManager") ClientManager clientManager) {
		this.clientManager = clientManager;
	}
	
	@Autowired
	public void setCreditManager(
			@Qualifier("creditManager") CreditManager creditManager) {
		this.creditManager = creditManager;
	}


	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String delete() {
		id = new Long(getParameter("id"));

		if (id != null) {
			commandeManager.remove(id);
			addMessage("deleted.ok");
		} else
			addMessage("deleted.nok");

		return "success";
	}

	public String edit() {
		// Workaround for not being able to set the id using #{param.id} when
		// using Spring-configured managed-beans
		try {
			id = new Long(getParameter("id"));
		} catch (Exception e) {
			id = null;
		}
		
		// Comparison to zero (vs. null) is required with MyFaces 1.2.2, not
		// with previous versions
		if (id != null && id != 0) {
			commande = commandeManager.get(id);
			if(commande.getClient() == null) commande.setClient(new Client());
		} else {
			commande = new Commande();
		}

		client = new Client();
		credit = new Credit();
		avance = new Avance();
		
		if(commande.getTypeVente() == TypeVente.CREDIT){
			showClient = true;
		}else{
			showClient = false;
		}
		
		return "edit";
	}
	
	public String detail() {
        if (id == null) {
            id = new Long(getParameter("id"));
        }

        if (id != null && id != 0) {
            commande = commandeManager.get(id);
        } else {
            commande = new Commande();
        }

        return "detail";
    }

	public String save() {
		boolean isNew = (commande.getId() == null || commande.getId() == 0);
		
		//check if new client > save new client
		if(commande.getClient() != null 
				&& commande.getClient().getId() <= 0 && showClient){
			if(validateClientForm()){
				client = clientManager.save(client);
				commande.setClient(client);
			}else
				addError("");
			
		}
		
		if (commande.getClient().getId() <= 0) 
			commande.setClient(null);
		
		commande = commandeManager.save(commande);
		
		if (commande.getTypeVente() == TypeVente.CREDIT && isNew) {
			credit.setClient(commande.getClient());
			credit.setCommande(commande);
			credit.setDateCredit(commande.getDateCommande());
			creditManager.save(credit);
		}

		String key = (isNew) ? "commande.added" : "commande.updated";
		addMessage(key);

		//increment reference + check if is the sum year > init counter
		if (isNew){
			String ref = (String) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("commandeRef");
			String[] reftable = ref.split("/");
			Long count = Long.valueOf(reftable[0]);
			int year = Integer.valueOf(reftable[1]);
			if (year == Calendar.getInstance().get(Calendar.YEAR))
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("commandeRef", (count + 1) + "/" + Calendar.getInstance().get(Calendar.YEAR));
			else
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("commandeRef", "1/" + Calendar.getInstance().get(Calendar.YEAR));
			
			
		}
			
		return "list";
	}
	
	private boolean validateClientForm() {
		// TODO Auto-generated method stub
		return true;
	}

	public void addLigneCommande() {
		Medicament med = medicamentManager.get(medicament.getId());
		if (!checkExistLigneCommande()) {
			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setCommande(commande);
			ligneCommande.setMedicament(med);
			ligneCommande.setNbrMedicament(nbrMedicament);
			commande.getLigneCommandes().add(ligneCommande);
		} else
			addError("bonLivraison.lbl.medicament.existe", med.getLibelle());
		
	}

	private boolean checkExistLigneCommande() {
		for (LigneCommande ligneCommande : commande.getLigneCommandes()) {
			if (ligneCommande.getMedicament().getId() == medicament.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeLigneCommande() {
		log.info("Try to remove a ligne bon livraison [medicament id]:#"
				+ medicament.getId());
		for (int i = 0; i < commande.getLigneCommandes().size(); i++) {
			if (commande.getLigneCommandes().get(i).getMedicament().getId() == medicament.getId()) {
				commande.getLigneCommandes().remove(i);
			}
		}
		
	}

	public List<Medicament> getMedicaments(){
		return sort(medicamentManager.getAll(), "libelle");
	}

	public Medicament getMedicament() {
		return medicament;
	}
	
	public List<KeyValue> getTypeVentes(){
		List<KeyValue> typeVentes = new ArrayList<KeyValue>(); 
		for (TypeVente typeVente : TypeVente.values()) {
			typeVentes.add(new KeyValue(typeVente.name(), typeVente));
		}
		
		return typeVentes;
	}
	
	public void showHideClient(){
		if(showClient)
			showClient = false;
		else
			showClient = true;
	}
	
	public List<Client> getClients(){
		return sort(clientManager.getAll(), "fullName");
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNbrMedicament() {
		return nbrMedicament;
	}

	public void setNbrMedicament(int nbrMedicament) {
		this.nbrMedicament = nbrMedicament;
	}

	public boolean isShowClient() {
		return showClient;
	}

	public void setShowClient(boolean showClient) {
		this.showClient = showClient;
	}
}