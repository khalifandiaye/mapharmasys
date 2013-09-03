package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Commande;
import ma.mapharmasys.service.CommandeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("commandeForm")
@Scope("request")
public class CommandeForm extends BasePage implements Serializable {
    private CommandeManager commandeManager;
    private Commande commande = new Commande();
    private Long id;

    @Autowired
    public void setCommandeManager(@Qualifier("commandeManager") CommandeManager commandeManager) {
        this.commandeManager = commandeManager;
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
        commandeManager.remove(commande.getId());
        addMessage("commande.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            commande = commandeManager.get(id);
        } else {
            commande = new Commande();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (commande.getId() == null || commande.getId() == 0);
        commandeManager.save(commande);

        String key = (isNew) ? "commande.added" : "commande.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 