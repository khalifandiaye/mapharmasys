package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.CreditDao;
import ma.mapharmasys.model.Credit;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Credit objects.
 *
 */
@Repository("creditDao")
public class CreditDaoHibernate extends GenericDaoHibernate<Credit, Long> implements CreditDao {

    /**
     * Constructor to create a Generics-based version using Credit as the entity
     */
    public CreditDaoHibernate() {
        super(Credit.class);
    }

}
