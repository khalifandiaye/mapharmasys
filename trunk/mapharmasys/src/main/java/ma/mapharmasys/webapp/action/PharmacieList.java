package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.PharmacieManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pharmacieList")
@Scope("session")
public class PharmacieList extends BasePage implements Serializable {
    private String query;
    private PharmacieManager pharmacieManager;

    @Autowired
    public void setPharmacieManager(@Qualifier("pharmacieManager") PharmacieManager pharmacieManager) {
        this.pharmacieManager = pharmacieManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public PharmacieList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Pharmacie> getPharmacies() {
        try {
            return pharmacieManager.search(query, Pharmacie.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(pharmacieManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}