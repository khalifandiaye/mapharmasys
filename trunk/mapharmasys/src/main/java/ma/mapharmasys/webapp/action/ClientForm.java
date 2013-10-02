package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Avance;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.AvanceManager;
import ma.mapharmasys.service.ClientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("clientForm")
@Scope("session")
public class ClientForm extends BasePage implements Serializable {
    private ClientManager clientManager;
    private AvanceManager avanceManager;
    
    private Client client = new Client();
    private Avance avance = new Avance();
    private Long id;

    @Autowired
    public void setClientManager(@Qualifier("clientManager") ClientManager clientManager) {
        this.clientManager = clientManager;
    }
    
    @Autowired
    public void setAvanceManager(@Qualifier("avanceManager") AvanceManager avanceManager) {
        this.avanceManager = avanceManager;
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
    	id = new Long(getParameter("id"));

		if (id != null) {
			clientManager.remove(id);
			addMessage("deleted.ok");
		} else
			addMessage("deleted.nok");

		return "success";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
    	try {
			id = new Long(getParameter("id"));
		} catch (Exception e) {
			id = null;
		}
    	// Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            client = clientManager.get(id);
        } else {
            client = new Client();
        }

        return "edit";
    }
    
    public void addAvance(){
    	avance.setClient(client);
    	avanceManager.save(avance);
    }

    public String detail() {
        if (id == null) {
            id = new Long(getParameter("id"));
        }

        if (id != null && id != 0) {
            client = clientManager.get(id);
        } else {
            client = new Client();
        }

        return "detail";
    }
    
    public String save() {
        boolean isNew = (client.getId() == null || client.getId() == 0);
        clientManager.save(client);

        String key = (isNew) ? "client.added" : "client.updated";
        addMessage(key);

        return "list";
    }

	public Avance getAvance() {
		return avance;
	}

	public void setAvance(Avance avance) {
		this.avance = avance;
	}
} 