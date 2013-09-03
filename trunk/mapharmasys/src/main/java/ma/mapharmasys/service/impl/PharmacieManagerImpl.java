package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.PharmacieDao;
import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.PharmacieManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("pharmacieManager")
public class PharmacieManagerImpl extends GenericManagerImpl<Pharmacie, Long> implements PharmacieManager {
	PharmacieDao pharmacieDao;

    @Autowired
    public PharmacieManagerImpl(PharmacieDao pharmacieDao) {
        super(pharmacieDao);
        this.pharmacieDao = pharmacieDao;
    }
}