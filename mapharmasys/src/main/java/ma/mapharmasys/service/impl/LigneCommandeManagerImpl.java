package ma.mapharmasys.service.impl;

import java.util.List;

import ma.mapharmasys.dao.LigneCommandeDao;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.LigneCommande;
import ma.mapharmasys.service.LigneCommandeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("ligneCommandeManager")
public class LigneCommandeManagerImpl extends GenericManagerImpl<LigneCommande, Long> implements LigneCommandeManager {
	LigneCommandeDao ligneCommandeDao;

    @Autowired
    public LigneCommandeManagerImpl(LigneCommandeDao ligneCommandeDao) {
        super(ligneCommandeDao);
        this.ligneCommandeDao = ligneCommandeDao;
    }

	@Override
	public List<LigneCommande> listLCByCommande(Long commandeId) {
		return ligneCommandeDao.listLCByCommande(commandeId);
	}

	@Override
	public void deleteByCommande(Commande commande) {
		ligneCommandeDao.deleteByCommande(commande);
	}
}