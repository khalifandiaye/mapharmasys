package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Echange;
import ma.mapharmasys.service.EchangeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("echangeList")
@Scope("session")
public class EchangeList extends BasePage implements Serializable {
    private String query;
    private EchangeManager echangeManager;

    @Autowired
    public void setEchangeManager(@Qualifier("echangeManager") EchangeManager echangeManager) {
        this.echangeManager = echangeManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public EchangeList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Echange> getEchanges() {
        try {
            return echangeManager.search(query, Echange.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(echangeManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}