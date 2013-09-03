package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.service.BonLivraisonManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bonLivraisonList")
@Scope("session")
public class BonLivraisonList extends BasePage implements Serializable {
    private String query;
    private BonLivraisonManager bonLivraisonManager;

    @Autowired
    public void setBonLivraisonManager(@Qualifier("bonLivraisonManager") BonLivraisonManager bonLivraisonManager) {
        this.bonLivraisonManager = bonLivraisonManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public BonLivraisonList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<BonLivraison> getBonLivraisons() {
        try {
            return bonLivraisonManager.search(query, BonLivraison.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(bonLivraisonManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}