package ma.mapharmasys.service;

import java.util.List;

import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.LigneCommande;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 */
public interface LigneCommandeManager extends GenericManager<LigneCommande, Long> {

	/**
	 * Liste ligne commandes by commande
	 * @param id
	 * @return
	 */
	List<LigneCommande> listLCByCommande(Long id);

	/**
	 * supprimer ligne commandes par commande
	 * @param commande
	 */
	void deleteByCommande(Commande commande);
    
}
