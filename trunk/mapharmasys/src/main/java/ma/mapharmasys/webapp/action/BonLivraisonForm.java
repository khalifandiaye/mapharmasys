package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;

import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.model.LigneBonLivraison;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.BonLivraisonManager;
import ma.mapharmasys.service.FournisseurManager;
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
	private FournisseurManager fournisseurManager;

	private BonLivraison bonLivraison = new BonLivraison();
	private Medicament medicament = new Medicament();

	private int nbrMedicament = 1;
	private Long id;
	private Long medicamentId;

	private List<LigneBonLivraison> ligneBonLivraisons = new ArrayList<LigneBonLivraison>();

	@Autowired
	public void setBonLivraisonManager(
			@Qualifier("bonLivraisonManager") BonLivraisonManager bonLivraisonManager) {
		this.bonLivraisonManager = bonLivraisonManager;
	}
	
	@Autowired
	public void setFournisseurManager(
			@Qualifier("fournisseurManager") FournisseurManager fournisseurManager) {
		this.fournisseurManager = fournisseurManager;
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

	public String delete() {
		id = new Long(getParameter("id"));

		if (id != null) {
			bonLivraisonManager.remove(id);
			addMessage("bonLivraison.deleted.ok");
		} else
			addMessage("bonLivraison.deleted.nok");

		return "success";
	}

	public String validateBonLivraison() {
		id = new Long(getParameter("id"));

		if (id != null) {
			bonLivraison = bonLivraisonManager.get(id);
			for (LigneBonLivraison ligneBonLivraison : bonLivraison
					.getLigneBonLivraisons()) {
				log.info("Try to add " + ligneBonLivraison.getNbrMedicament()
						+ " of "
						+ ligneBonLivraison.getMedicament().getLibelle()
						+ " to stock");
				medicament = ligneBonLivraison.getMedicament();
				medicament.setNbrEnStock(medicament.getNbrEnStock()
						+ ligneBonLivraison.getNbrMedicament());
				medicamentManager.save(medicament);
			}

			bonLivraison.setValide(true);
			bonLivraisonManager.save(bonLivraison);
			addMessage("bonLivraison.valide.ok");
		} else
			addMessage("bonLivraison.valide.nok");

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
			log.info("try to load bl by id #" + id);
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

		bonLivraison.setLigneBonLivraisons(ligneBonLivraisons);

		bonLivraisonManager.save(bonLivraison);

		String key = (isNew) ? "bonLivraison.added" : "bonLivraison.updated";
		addMessage(key);

		return "list";
	}

	public void addLigneBonLivraison() {
		Medicament med = medicamentManager.get(medicament.getId());
		if (!checkExistLBL()) {
			LigneBonLivraison ligneBonLivraison = new LigneBonLivraison();
			ligneBonLivraison.setBonLivraison(bonLivraison);
			ligneBonLivraison.setMedicament(med);
			ligneBonLivraison.setNbrMedicament(nbrMedicament);
			this.ligneBonLivraisons.add(ligneBonLivraison);
		} else
			addError("bonLivraison.lbl.medicament.existe", med.getLibelle());
	}

	private boolean checkExistLBL() {
		for (LigneBonLivraison lbl : ligneBonLivraisons) {
			if (lbl.getMedicament().getId() == medicament.getId()) {
				return true;
			}
		}
		return false;
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
	
	public List<Medicament> getFournisseurs() {
		return sort(fournisseurManager.getAll(), "nom");
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