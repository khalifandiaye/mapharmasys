package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.DetailBonLivraisonDao;
import ma.mapharmasys.model.DetailBonLivraison;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Client objects.
 *
 */
@Repository("detailBonLivraisonDao")
public class DetailBonLivraisonDaoHibernate extends GenericDaoHibernate<DetailBonLivraison, Long> implements DetailBonLivraisonDao {

    /**
     * Constructor to create a Generics-based version using Client as the entity
     */
    public DetailBonLivraisonDaoHibernate() {
        super(DetailBonLivraison.class);
    }

}
