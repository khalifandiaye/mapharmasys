package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.service.CommandeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("commandeList")
@Scope("session")
public class CommandeList extends BasePage implements Serializable {
    private String query;
    private CommandeManager commandeManager;

    @Autowired
    public void setCommandeManager(@Qualifier("commandeManager") CommandeManager commandeManager) {
        this.commandeManager = commandeManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public CommandeList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Commande> getCommandes() {
        try {
            return commandeManager.search(query, Commande.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(commandeManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}