package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.CreditDao;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.CreditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("creditManager")
public class CreditManagerImpl extends GenericManagerImpl<Credit, Long> implements CreditManager {
	CreditDao creditDao;

    @Autowired
    public CreditManagerImpl(CreditDao creditDao) {
        super(creditDao);
        this.creditDao = creditDao;
    }
}