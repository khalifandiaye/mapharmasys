package ma.mapharmasys.dao;

import ma.mapharmasys.model.Commande;

/**
 * Commande Data Access Object (DAO) interface.
 *
 */
public interface CommandeDao extends GenericDao<Commande, Long> {

	/**
	 * retrouver le dernier numero commande
	 * @return
	 */
	Long getLastNumero();

	void validateCommande(Long commandeId);


}
