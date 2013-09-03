package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.DetailEchangeDao;
import ma.mapharmasys.model.DetailEchange;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve DetailEchange objects.
 *
 */
@Repository("detailEchangeDao")
public class DetailEchangeDaoHibernate extends GenericDaoHibernate<DetailEchange, Long> implements DetailEchangeDao {

    /**
     * Constructor to create a Generics-based version using DetailEchange as the entity
     */
    public DetailEchangeDaoHibernate() {
        super(DetailEchange.class);
    }

}
