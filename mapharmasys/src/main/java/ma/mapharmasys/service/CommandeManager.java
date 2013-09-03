package ma.mapharmasys.service;

import ma.mapharmasys.model.Commande;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 */
public interface CommandeManager extends GenericManager<Commande, Long> {

	/**
	 * retrouver le dernier numero commande
	 * @return
	 */
	Long getLastNumero();
	
	/**
	 * valider une commande
	 */
	void validateCommande(Long commandeId);

}
