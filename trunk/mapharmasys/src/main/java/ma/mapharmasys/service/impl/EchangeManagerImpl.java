package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.EchangeDao;
import ma.mapharmasys.model.Echange;
import ma.mapharmasys.service.EchangeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("echangeManager")
public class EchangeManagerImpl extends GenericManagerImpl<Echange, Long> implements EchangeManager {
	EchangeDao echangeDao;

    @Autowired
    public EchangeManagerImpl(EchangeDao echangeDao) {
        super(echangeDao);
        this.echangeDao = echangeDao;
    }

}