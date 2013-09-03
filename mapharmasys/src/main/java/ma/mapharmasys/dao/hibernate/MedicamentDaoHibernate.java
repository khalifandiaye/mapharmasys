package ma.mapharmasys.dao.hibernate;

import java.util.List;

import ma.mapharmasys.dao.MedicamentDao;
import ma.mapharmasys.model.Medicament;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Meicament objects.
 *
 */
@Repository("medicamentDao")
public class MedicamentDaoHibernate extends GenericDaoHibernate<Medicament, Long> implements MedicamentDao {

    /**
     * Constructor to create a Generics-based version using Medicament as the entity
     */
    public MedicamentDaoHibernate() {
        super(Medicament.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicament> getMedicaments() {
		 Query qry = getSession().createQuery("FROM Medicament m WHERE m.deleted=false order by upper(m.libelle)");
        return qry.list();
	}

}
