package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.BonLivraisonDao;
import ma.mapharmasys.model.BonLivraison;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve BonLivraison objects.
 *
 */
@Repository("bonLivraisonDao")
public class BonLivraisonDaoHibernate extends GenericDaoHibernate<BonLivraison, Long> implements BonLivraisonDao {

    /**
     * Constructor to create a Generics-based version using BonLivraison as the entity
     */
    public BonLivraisonDaoHibernate() {
        super(BonLivraison.class);
    }

}
