package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.PharmacieDao;
import ma.mapharmasys.model.Pharmacie;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Pharmacie objects.
 *
 */
@Repository("pharmacieDao")
public class PharmacieDaoHibernate extends GenericDaoHibernate<Pharmacie, Long> implements PharmacieDao {

    /**
     * Constructor to create a Generics-based version using Pharmacie as the entity
     */
    public PharmacieDaoHibernate() {
        super(Pharmacie.class);
    }

}
