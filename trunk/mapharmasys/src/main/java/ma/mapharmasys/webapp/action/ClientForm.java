package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.ClientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("clientForm")
@Scope("request")
public class ClientForm extends BasePage implements Serializable {
    private ClientManager clientManager;
    private Client client = new Client();
    private Long id;

    @Autowired
    public void setClientManager(@Qualifier("clientManager") ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        clientManager.remove(client.getId());
        addMessage("client.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            client = clientManager.get(id);
        } else {
            client = new Client();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (client.getId() == null || client.getId() == 0);
        clientManager.save(client);

        String key = (isNew) ? "client.added" : "client.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 