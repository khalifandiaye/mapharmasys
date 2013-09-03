package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.CreditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("creditList")
@Scope("session")
public class CreditList extends BasePage implements Serializable {
    private String query;
    private CreditManager creditManager;

    @Autowired
    public void setCreditManager(@Qualifier("creditManager") CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public CreditList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Credit> getCredits() {
        try {
            return creditManager.search(query, Credit.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(creditManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}