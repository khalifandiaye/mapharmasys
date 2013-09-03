package ma.mapharmasys.dao;

import java.util.List;

import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.LigneCommande;

/**
 * LigneCommande Data Access Object (DAO) interface.
 *
 */
public interface LigneCommandeDao extends GenericDao<LigneCommande, Long> {

	/**
	 * Liste ligne commandes by commande
	 * @param commandeId
	 * @return
	 */
	List<LigneCommande> listLCByCommande(Long commandeId);

	void deleteByCommande(Commande commande);


}
