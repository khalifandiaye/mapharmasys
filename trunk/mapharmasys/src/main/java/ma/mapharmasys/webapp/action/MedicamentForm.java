package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("medicamentForm")
@Scope("request")
public class MedicamentForm extends BasePage implements Serializable {
    private MedicamentManager medicamentManager;
    private Medicament medicament = new Medicament();
    private Long id;

    @Autowired
    public void setMedicamentManager(@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
        this.medicamentManager = medicamentManager;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        medicamentManager.remove(medicament.getId());
        addMessage("medicament.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            medicament = medicamentManager.get(id);
        } else {
            medicament = new Medicament();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (medicament.getId() == null || medicament.getId() == 0);
        medicamentManager.save(medicament);

        String key = (isNew) ? "medicament.added" : "medicament.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 