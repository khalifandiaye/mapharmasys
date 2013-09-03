package ma.mapharmasys.webapp.action;

import java.io.Serializable;
import java.util.List;

import ma.mapharmasys.dao.SearchException;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.ClientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("clientList")
@Scope("session")
public class ClientList extends BasePage implements Serializable {
    private String query;
    private ClientManager clientManager;

    @Autowired
    public void setClientManager(@Qualifier("clientManager") ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public ClientList() {
        setSortColumn("id"); // sets the default sort column
    }

    public List<Client> getClients() {
        try {
            return clientManager.search(query, Client.class);
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(clientManager.getAll());
        }
    }

    public String search() {
        return "success";
    }
}