package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.PharmacieManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pharmacieForm")
@Scope("request")
public class PharmacieForm extends BasePage implements Serializable {
    private PharmacieManager pharmacieManager;
    private Pharmacie pharmacie = new Pharmacie();
    private Long id;

    @Autowired
    public void setPharmacieManager(@Qualifier("pharmacieManager") PharmacieManager pharmacieManager) {
        this.pharmacieManager = pharmacieManager;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        pharmacieManager.remove(pharmacie.getId());
        addMessage("pharmacie.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            pharmacie = pharmacieManager.get(id);
        } else {
            pharmacie = new Pharmacie();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (pharmacie.getId() == null || pharmacie.getId() == 0);
        pharmacieManager.save(pharmacie);

        String key = (isNew) ? "pharmacie.added" : "pharmacie.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 