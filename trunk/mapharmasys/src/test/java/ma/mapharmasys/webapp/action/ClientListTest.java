package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.ClientManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientListTest extends BasePageTestCase {
    private ClientList bean;
    @Autowired
    private ClientManager clientManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new ClientList();
        bean.setClientManager(clientManager);

        // add a test client to the database
        Client client = new Client();

        // enter all required fields

        clientManager.save(client);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllClients() throws Exception {
        assertTrue(bean.getClients().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        clientManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getClients().size());
    }
}