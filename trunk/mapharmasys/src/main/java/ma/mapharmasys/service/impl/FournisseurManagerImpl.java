package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.FournisseurDao;
import ma.mapharmasys.model.Fournisseur;
import ma.mapharmasys.service.FournisseurManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("fournisseurManager")
public class FournisseurManagerImpl extends GenericManagerImpl<Fournisseur, Long> implements FournisseurManager {
	FournisseurDao fournisseurDao;

    @Autowired
    public FournisseurManagerImpl(FournisseurDao fournisseurDao) {
        super(fournisseurDao);
        this.fournisseurDao = fournisseurDao;
    }
}