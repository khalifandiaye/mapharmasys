package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;
import ma.mapharmasys.util.MedicamentBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("medicamentListCommon")
@Scope("session")
public class MedicamentListCommon extends BasePage implements Serializable {
    private static final long serialVersionUID = 5005612769815L;

    private MedicamentManager medicamentManager;
    
    private List<MedicamentBean> medicamentBeans = new ArrayList<MedicamentBean>();
    private MedicamentBean medicamentBean = new MedicamentBean();
    
    @Autowired
	public void setMedicamentManager(
			@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
		this.medicamentManager = medicamentManager;
	}
    
    public List<MedicamentBean> getMedicamentBeans() {
		return medicamentBeans;
	}

	public void setMedicamentBeans(List<MedicamentBean> medicamentBeans) {
		this.medicamentBeans = medicamentBeans;
	}

	public MedicamentBean getMedicamentBean() {
		return medicamentBean;
	}

	public void setMedicamentBean(MedicamentBean medicamentBean) {
		this.medicamentBean = medicamentBean;
	}

	public List<Medicament> getMedicaments() {
		return sort(medicamentManager.getAll(), "libelle");
	}
    
    
    public void addMedicamentBean() {
		Medicament med = medicamentManager.get(medicamentBean.getMedicament().getId());
		if (!checkExistMedicamentBean()) {
			medicamentBeans.add(new MedicamentBean(med, medicamentBean.getQte()));
		} else
			addError("bonLivraison.lbl.medicament.existe", med.getLibelle());

	}

	private boolean checkExistMedicamentBean() {
		for (MedicamentBean bean : medicamentBeans) {
			if (bean.getMedicament().getId() == medicamentBean.getMedicament().getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMedicamentBean() {
		log.info("Try to remove a ligne bon livraison [medicament id]:#"
				+ medicamentBean.getMedicament().getId());
		for (int i = 0; i < medicamentBeans.size(); i++) {
			if (medicamentBeans.get(i).getMedicament().getId() == medicamentBean
					.getMedicament().getId()) {
				medicamentBeans.remove(i);
			}
		}

	}
}
