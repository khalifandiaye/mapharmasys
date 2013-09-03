package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.FormeDao;
import ma.mapharmasys.model.Forme;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Forme objects.
 *
 */
@Repository("formeDao")
public class FormeDaoHibernate extends GenericDaoHibernate<Forme, Long> implements FormeDao {

    /**
     * Constructor to create a Generics-based version using Forme as the entity
     */
    public FormeDaoHibernate() {
        super(Forme.class);
    }

}
