package ma.mapharmasys.dao;

import java.util.List;

import ma.mapharmasys.model.Medicament;

/**
 * Medicament Data Access Object (DAO) interface.
 *
 */
public interface MedicamentDao extends GenericDao<Medicament, Long> {

	/**
	 * Retrouver la lsite des medicament non suprime
	 * @return
	 */
	List<Medicament> getMedicaments();


}
