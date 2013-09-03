package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("medicamentList")
@Scope("session")
public class MedicamentList extends BasePage implements Serializable {
    private String query;
    private MedicamentManager medicamentManager;

    @Autowired
    public void setMedicamentManager(@Qualifier("medicamentManager") MedicamentManager medicamentManager) {
        this.medicamentManager = medicamentManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public MedicamentList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Medicament> getMedicaments() {
        try {
            return medicamentManager.search(query, Medicament.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(medicamentManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}