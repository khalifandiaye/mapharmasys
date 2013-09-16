package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.model.LigneBonLivraison;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.BonLivraisonManager;
import ma.mapharmasys.service.MedicamentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bonLivraisonForm")
@Scope("session")
public class BonLivraisonForm extends BasePage implements Serializable {
	private BonLivraisonManager bonLivraisonManager;
	private MedicamentManager medicamentManager;

	private BonLivraison bonLivraison = new BonLivraison();
	private Medicament medicament = new Medicament();

	private int nbrMedicament;
	private Long id;
	private Long medicamentId;
	private boolean useNow = false;

	private List<LigneBonLivraison> ligneBonLivraisons = new ArrayList<LigneBonLivraison>();

	@Autowired
	public void setBonLivraisonManager(
			@Qualifier("bonLivraisonManager") BonLivraisonManager bonLivraisonManager) {
		this.bonLivraisonManager = bonLivraisonManager;
	}

	@Autowired
	public void setMedicamentManager(
			@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
		this.medicamentManager = medicamentManager;
	}

	public BonLivraison getBonLivraison() {
		return bonLivraison;
	}

	public void setBonLivraison(BonLivraison bonLivraison) {
		this.bonLivraison = bonLivraison;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMedicamentId() {
		return medicamentId;
	}

	public void setMedicamentId(Long medicamentId) {
		this.medicamentId = medicamentId;
	}

	public void setUseNow(boolean useNow) {
		this.useNow = useNow;
	}

	public boolean isUseNow() {
		return useNow;
	}

	public String delete() {
		if (id == null) {
			id = new Long(getParameter("id"));
		}
		
		if (id != null) {
			bonLivraisonManager.remove(id);
			addMessage("bonLivraison.deleted.ok");
		}else
			addMessage("bonLivraison.deleted.nok");

		return "success";
	}

	public String edit() {
		// Workaround for not being able to set the id using #{param.id} when
		// using Spring-configured managed-beans
		id = new Long(getParameter("id"));
		
		// Comparison to zero (vs. null) is required with MyFaces 1.2.2, not
		// with previous versions
		if (id != null && id != 0) {
			log.info("try to load bl by id #"+id);
			bonLivraison = bonLivraisonManager.get(id);
			ligneBonLivraisons = bonLivraison.getLigneBonLivraisons();
		} else {
			bonLivraison = new BonLivraison();
			ligneBonLivraisons = new ArrayList<LigneBonLivraison>();
			nbrMedicament = 1;
			medicament = new Medicament();
		}

		return "edit";
	}

	public String save() {
		boolean isNew = (bonLivraison.getId() == null || bonLivraison.getId() == 0);
		
		if (isNew) bonLivraison.setDateFacturation(Calendar.getInstance().getTime());
		
		bonLivraison.setLigneBonLivraisons(ligneBonLivraisons);
		
		bonLivraisonManager.save(bonLivraison);

		String key = (isNew) ? "bonLivraison.added" : "bonLivraison.updated";
		addMessage(key);

		if (isNew) {
			return "list";
		} else {
			return "edit";
		}
	}

	public void addLigneBonLivraison() {
		LigneBonLivraison ligneBonLivraison = new LigneBonLivraison();
		ligneBonLivraison.setBonLivraison(bonLivraison);
		ligneBonLivraison.setMedicament(medicamentManager.get(medicament
				.getId()));
		ligneBonLivraison.setNbrMedicament(nbrMedicament);
		this.ligneBonLivraisons.add(ligneBonLivraison);
	}

	public void removeLigneBonLivraison() {
		log.info("Try to remove a ligne bon livraison [medicament id]:#"
				+ medicamentId);
		for (int i = 0; i < ligneBonLivraisons.size(); i++) {
			if (ligneBonLivraisons.get(i).getMedicament().getId() == medicamentId) {
				ligneBonLivraisons.remove(i);
			}
		}
	}

	public List<LigneBonLivraison> getLigneBonLivraisons() {
		return ligneBonLivraisons;
	}

	public void setLigneBonLivraisons(List<LigneBonLivraison> ligneBonLivraisons) {
		this.ligneBonLivraisons = ligneBonLivraisons;
	}

	public List<Medicament> getMedicaments() {
		return sort(medicamentManager.getAll(), "libelle");
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public int getNbrMedicament() {
		return nbrMedicament;
	}

	public void setNbrMedicament(int nbrMedicament) {
		this.nbrMedicament = nbrMedicament;
	}
}