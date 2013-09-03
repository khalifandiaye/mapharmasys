package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.FournisseurDao;
import ma.mapharmasys.model.Fournisseur;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Fournisseur objects.
 *
 */
@Repository("fournisseurDao")
public class FournisseurDaoHibernate extends GenericDaoHibernate<Fournisseur, Long> implements FournisseurDao {

    /**
     * Constructor to create a Generics-based version using Fournisseur as the entity
     */
    public FournisseurDaoHibernate() {
        super(Fournisseur.class);
    }

}
