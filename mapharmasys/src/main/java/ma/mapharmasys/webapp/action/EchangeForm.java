package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Echange;
import ma.mapharmasys.service.EchangeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("echangeForm")
@Scope("request")
public class EchangeForm extends BasePage implements Serializable {
    private EchangeManager echangeManager;
    private Echange echange = new Echange();
    private Long id;

    @Autowired
    public void setEchangeManager(@Qualifier("echangeManager") EchangeManager echangeManager) {
        this.echangeManager = echangeManager;
    }

    public Echange getEchange() {
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
        if (id == null) {
            id = new Long(getParameter("id"));
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

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 