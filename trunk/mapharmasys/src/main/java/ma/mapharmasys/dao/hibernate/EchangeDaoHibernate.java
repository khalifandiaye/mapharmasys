package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.EchangeDao;
import ma.mapharmasys.model.Echange;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Echange objects.
 *
 */
@Repository("echangeDao")
public class EchangeDaoHibernate extends GenericDaoHibernate<Echange, Long> implements EchangeDao {

    /**
     * Constructor to create a Generics-based version using Echange as the entity
     */
    public EchangeDaoHibernate() {
        super(Echange.class);
    }

}
