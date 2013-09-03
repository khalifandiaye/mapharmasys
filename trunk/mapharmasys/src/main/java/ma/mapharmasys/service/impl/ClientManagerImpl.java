package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.ClientDao;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.ClientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("clientManager")
public class ClientManagerImpl extends GenericManagerImpl<Client, Long> implements ClientManager {
	ClientDao clientDao;

    @Autowired
    public ClientManagerImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
    }
}