package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ma.mapharmasys.Constants.TypeEchange;
import ma.mapharmasys.model.DetailEchange;
import ma.mapharmasys.model.Echange;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.EchangeManager;
import ma.mapharmasys.service.MedicamentManager;
import ma.mapharmasys.service.PharmacieManager;
import ma.mapharmasys.util.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("echangeForm")
@Scope("session")
public class EchangeForm extends BasePage implements Serializable {
    private EchangeManager echangeManager;
    private PharmacieManager pharmacieManager;
    private MedicamentManager medicamentManager;
    
    private Echange echange = new Echange();
    private Medicament medicament = new Medicament();
    private int nbrMedicament = 1;
    private Long id;
    

    @Autowired
    public void setEchangeManager(@Qualifier("echangeManager") EchangeManager echangeManager) {
        this.echangeManager = echangeManager;
    }

    @Autowired
    public void setPharmacieManager(@Qualifier("pharmacieManager") PharmacieManager pharmacieManager) {
        this.pharmacieManager = pharmacieManager;
    }
    
    @Autowired
	public void setMedicamentManager(
			@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
		this.medicamentManager = medicamentManager;
	}
    
	public Echange getEchange() {
		if(echange.getPharmacie().getId() != null 
				&& echange.getPharmacie().getId() > 0)
			echange.setPharmacie(pharmacieManager.get(echange.getPharmacie().getId()));
		
        return echange;
    }

    public void setEchange(Echange echange) {
        this.echange = echange;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        echangeManager.remove(echange.getId());
        addMessage("echange.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
    	try {
			id = new Long(getParameter("id"));
		} catch (Exception e) {
			id = null;
		}
		
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            echange = echangeManager.get(id);
        } else {
            echange = new Echange();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (echange.getId() == null || echange.getId() == 0);
        
        echangeManager.save(echange);

        String key = (isNew) ? "echange.added" : "echange.updated";
        addMessage(key);

        return "list";
    }
    
    
    public void addDetailEchange() {
		Medicament med = medicamentManager.get(medicament.getId());
		if (!checkExistDetailEchange()) {
			DetailEchange detailEchange = new DetailEchange();
			detailEchange.setEchange(echange);
			detailEchange.setMedicament(med);
			detailEchange.setQteMedicament(nbrMedicament);
			echange.getDetailEchanges().add(detailEchange);
		} else
			addError("bonLivraison.lbl.medicament.existe", med.getLibelle());
		
		nbrMedicament = 1;
		medicament = new Medicament();
		
	}

	private boolean checkExistDetailEchange() {
		for (DetailEchange detailEchange : echange.getDetailEchanges()) {
			if (detailEchange.getMedicament().getId() == medicament.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeDetailEchange() {
		log.info("Try to remove a ligne bon livraison [medicament id]:#"
				+ medicament.getId());
		for (int i = 0; i < echange.getDetailEchanges().size(); i++) {
			if (echange.getDetailEchanges().get(i).getMedicament().getId() == medicament.getId()) {
				echange.getDetailEchanges().remove(i);
			}
		}
		
	}
	
    public List<Pharmacie> getPharmacies(){
    	return sort(pharmacieManager.getAll(), "nomPharmacie");
    }
    
	public int getNbrMedicament() {
		return nbrMedicament;
	}

	public void setNbrMedicament(int nbrMedicament) {
		this.nbrMedicament = nbrMedicament;
	}
	
	public List<Medicament> getMedicaments(){
		return sort(medicamentManager.getAll(), "libelle");
	}
	
	 public List<KeyValue> getTypeEchanges(){
			List<KeyValue> typeVentes = new ArrayList<KeyValue>(); 
			for (TypeEchange typeEchange : TypeEchange.values()) {
				typeVentes.add(new KeyValue(typeEchange.name(), typeEchange));
			}
			
			return typeVentes;
		}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
} 