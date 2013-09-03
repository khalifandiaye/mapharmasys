package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Fournisseur;
import ma.mapharmasys.service.FournisseurManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fournisseurList")
@Scope("session")
public class FournisseurList extends BasePage implements Serializable {
    private String query;
    private FournisseurManager fournisseurManager;

    @Autowired
    public void setFournisseurManager(@Qualifier("fournisseurManager") FournisseurManager fournisseurManager) {
        this.fournisseurManager = fournisseurManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public FournisseurList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Fournisseur> getFournisseurs() {
        try {
            return fournisseurManager.search(query, Fournisseur.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(fournisseurManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}