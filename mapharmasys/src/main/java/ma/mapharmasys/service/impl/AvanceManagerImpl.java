package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.AvanceDao;
import ma.mapharmasys.dao.CreditDao;
import ma.mapharmasys.model.Avance;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.AvanceManager;
import ma.mapharmasys.service.CreditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("avanceManager")
public class AvanceManagerImpl extends GenericManagerImpl<Avance, Long> implements AvanceManager {
	AvanceDao avanceDao;

    @Autowired
    public AvanceManagerImpl(AvanceDao avanceDao) {
        super(avanceDao);
        this.avanceDao = avanceDao;
    }
}