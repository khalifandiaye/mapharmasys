package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.AvanceDao;
import ma.mapharmasys.model.Avance;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Avance objects.
 *
 */
@Repository("avanceDao")
public class AvanceDaoHibernate extends GenericDaoHibernate<Avance, Long> implements AvanceDao {

    /**
     * Constructor to create a Generics-based version using Credit as the entity
     */
    public AvanceDaoHibernate() {
        super(Avance.class);
    }

}
