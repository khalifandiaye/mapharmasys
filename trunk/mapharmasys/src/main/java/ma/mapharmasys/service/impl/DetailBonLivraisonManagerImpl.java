package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.DetailBonLivraisonDao;
import ma.mapharmasys.model.DetailBonLivraison;
import ma.mapharmasys.service.DetailBonLivraisonManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("detailBonLivraisonManager")
public class DetailBonLivraisonManagerImpl extends GenericManagerImpl<DetailBonLivraison, Long> implements DetailBonLivraisonManager {
	DetailBonLivraisonDao bonLivraisonDao;

    @Autowired
    public DetailBonLivraisonManagerImpl(DetailBonLivraisonDao bonLivraisonDao) {
        super(bonLivraisonDao);
        this.bonLivraisonDao = bonLivraisonDao;
    }
}