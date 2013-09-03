package ma.mapharmasys.service;

import java.util.List;

import ma.mapharmasys.model.Medicament;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 */
public interface MedicamentManager extends GenericManager<Medicament, Long> {

	/**
	 * Retrouver la liste de medicament non suprime
	 * @return
	 */
	List<Medicament> getMedicaments();
    
}
