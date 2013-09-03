package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Forme;
import ma.mapharmasys.service.FormeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formeForm")
@Scope("request")
public class FormeForm extends BasePage implements Serializable {
    private FormeManager formeManager;
    private Forme forme = new Forme();
    private Long id;

    @Autowired
    public void setFormeManager(@Qualifier("formeManager") FormeManager formeManager) {
        this.formeManager = formeManager;
    }

    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        formeManager.remove(forme.getId());
        addMessage("forme.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            forme = formeManager.get(id);
        } else {
            forme = new Forme();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (forme.getId() == null || forme.getId() == 0);
        formeManager.save(forme);

        String key = (isNew) ? "forme.added" : "forme.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 