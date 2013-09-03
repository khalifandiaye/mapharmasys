package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.ClientDao;
import ma.mapharmasys.model.Client;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve DetailBonLivraison objects.
 *
 */
@Repository("clientDao")
public class ClientDaoHibernate extends GenericDaoHibernate<Client, Long> implements ClientDao {

    /**
     * Constructor to create a Generics-based version using DetailBonLivraison as the entity
     */
    public ClientDaoHibernate() {
        super(Client.class);
    }

}
