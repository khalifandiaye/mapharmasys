package ma.mapharmasys.dao.hibernate;

import ma.mapharmasys.dao.TypeMedicamentDao;
import ma.mapharmasys.model.TypeMedicament;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Type objects.
 *
 */
@Repository("typeMedicamentDao")
public class TypeMedicamentDaoHibernate extends GenericDaoHibernate<TypeMedicament, Long> implements TypeMedicamentDao {

    /**
     * Constructor to create a Generics-based version using Type as the entity
     */
    public TypeMedicamentDaoHibernate() {
        super(TypeMedicament.class);
    }

}
