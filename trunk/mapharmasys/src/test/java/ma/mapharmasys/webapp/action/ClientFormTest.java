package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Client;
import ma.mapharmasys.service.ClientManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientFormTest extends BasePageTestCase {
    private ClientForm bean;
    @Autowired
    private ClientManager clientManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new ClientForm();
        bean.setClientManager(clientManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Client client = new Client();

        // enter all required fields
        bean.setClient(client);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getClient());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getClient());
        Client client = bean.getClient();

        // update required fields
        bean.setClient(client);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Client client = new Client();
        client.setId(-2L);
        bean.setClient(client);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}