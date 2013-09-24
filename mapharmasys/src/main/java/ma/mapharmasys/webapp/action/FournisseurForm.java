package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Fournisseur;
import ma.mapharmasys.service.FournisseurManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fournisseurForm")
@Scope("request")
public class FournisseurForm extends BasePage implements Serializable {
    private FournisseurManager fournisseurManager;
    private Fournisseur fournisseur = new Fournisseur();
    private Long id;

    @Autowired
    public void setFournisseurManager(@Qualifier("fournisseurManager") FournisseurManager fournisseurManager) {
        this.fournisseurManager = fournisseurManager;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
    	id = new Long(getParameter("id"));

		if (id != null) {
			fournisseurManager.remove(id);
			addMessage("deleted.ok", "Fournisseur");
		} else
			addMessage("deleted.nok");

		return "success";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        id = new Long(getParameter("id"));
        
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            fournisseur = fournisseurManager.get(id);
        } else {
            fournisseur = new Fournisseur();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (fournisseur.getId() == null || fournisseur.getId() == 0);
        fournisseurManager.save(fournisseur);

        String key = (isNew) ? "fournisseur.added" : "fournisseur.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 