package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.DetailEchangeDao;
import ma.mapharmasys.model.DetailEchange;
import ma.mapharmasys.service.DetailEchangeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("detailEchangeManager")
public class DetailEchangeManagerImpl extends GenericManagerImpl<DetailEchange, Long> implements DetailEchangeManager {
	DetailEchangeDao detailEchangeDao;

    @Autowired
    public DetailEchangeManagerImpl(DetailEchangeDao detailEchangeDao) {
        super(detailEchangeDao);
        this.detailEchangeDao = detailEchangeDao;
    }
}