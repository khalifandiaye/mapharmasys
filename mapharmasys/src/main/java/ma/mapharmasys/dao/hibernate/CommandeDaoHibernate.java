package ma.mapharmasys.dao.hibernate;

import java.util.List;

import ma.mapharmasys.dao.CommandeDao;
import ma.mapharmasys.model.Commande;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Commande objects.
 *
 */
@Repository("commandeDao")
public class CommandeDaoHibernate extends GenericDaoHibernate<Commande, Long> implements CommandeDao {

    /**
     * Constructor to create a Generics-based version using Commande as the entity
     */
    public CommandeDaoHibernate() {
        super(Commande.class);
    }

	@Override
	public Long getLastNumero() {
		Query qry = getSession().createQuery("SELECT MAX(numero) from Commande");
		List<Object> objResults = qry.list();
		if (objResults != null && !objResults.isEmpty()) {
			return  objResults.get(0) != null ? (Long) objResults.get(0) : 0L;
		}
		
		return 0L;
	}

	@Override
	public void validateCommande(Long commandeId) {
		 Query qry = getSession().createQuery("UPDATE Commande c Set c.valide=true WHERE c.id=:commandeId");
	     qry.setParameter("commandeId", commandeId).executeUpdate();
	}

}
