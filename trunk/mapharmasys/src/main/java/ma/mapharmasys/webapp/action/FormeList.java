package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Forme;
import ma.mapharmasys.service.FormeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("formeList")
@Scope("session")
public class FormeList extends BasePage implements Serializable {
    private String query;
    private FormeManager formeManager;

    @Autowired
    public void setFormeManager(@Qualifier("formeManager") FormeManager formeManager) {
        this.formeManager = formeManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public FormeList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Forme> getFormes() {
        try {
            return formeManager.search(query, Forme.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(formeManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}