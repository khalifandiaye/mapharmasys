package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.BonLivraisonDao;
import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.service.BonLivraisonManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("bonLivraisonManager")
public class BonLivraisonManagerImpl extends GenericManagerImpl<BonLivraison, Long> implements BonLivraisonManager {
	BonLivraisonDao bonLivraisonDao;

    @Autowired
    public BonLivraisonManagerImpl(BonLivraisonDao bonLivraisonDao) {
        super(bonLivraisonDao);
        this.bonLivraisonDao = bonLivraisonDao;
    }
}