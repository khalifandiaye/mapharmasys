package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.FormeDao;
import ma.mapharmasys.model.Forme;
import ma.mapharmasys.service.FormeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("formeManager")
public class FormeManagerImpl extends GenericManagerImpl<Forme, Long> implements FormeManager {
    FormeDao formeDao;

    @Autowired
    public FormeManagerImpl(FormeDao formeDao) {
        super(formeDao);
        this.formeDao = formeDao;
    }
}