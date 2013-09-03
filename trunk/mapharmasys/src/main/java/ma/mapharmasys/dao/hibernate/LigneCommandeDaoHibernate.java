package ma.mapharmasys.dao.hibernate;

import java.util.List;

import ma.mapharmasys.dao.LigneCommandeDao;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.LigneCommande;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve LigneCommande objects.
 *
 */
@Repository("ligneCommandeDao")
public class LigneCommandeDaoHibernate extends GenericDaoHibernate<LigneCommande, Long> implements LigneCommandeDao {

    /**
     * Constructor to create a Generics-based version using LigneCommande as the entity
     */
    public LigneCommandeDaoHibernate() {
        super(LigneCommande.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> listLCByCommande(Long commandeId) {
		return getSession().createCriteria(LigneCommande.class).add(Restrictions.eq("commande.id", commandeId)).list();
	}

	@Override
	public void deleteByCommande(Commande commande) {
		 Query qry = getSession().createQuery("DELETE FROM LigneCommande lc WHERE lc.commande= :cmd");
	     qry.setParameter("cmd", commande).executeUpdate();		
	}

}
