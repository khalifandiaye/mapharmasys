package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.service.BonLivraisonManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bonLivraisonForm")
@Scope("request")
public class BonLivraisonForm extends BasePage implements Serializable {
    private BonLivraisonManager bonLivraisonManager;
    private BonLivraison bonLivraison = new BonLivraison();
    private Long id;

    @Autowired
    public void setBonLivraisonManager(@Qualifier("bonLivraisonManager") BonLivraisonManager bonLivraisonManager) {
        this.bonLivraisonManager = bonLivraisonManager;
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

    public String delete() {
        bonLivraisonManager.remove(bonLivraison.getId());
        addMessage("bonLivraison.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            bonLivraison = bonLivraisonManager.get(id);
        } else {
            bonLivraison = new BonLivraison();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (bonLivraison.getId() == null || bonLivraison.getId() == 0);
        bonLivraisonManager.save(bonLivraison);

        String key = (isNew) ? "bonLivraison.added" : "bonLivraison.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 