package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.service.CommandeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandeListTest extends BasePageTestCase {
    private CommandeList bean;
    @Autowired
    private CommandeManager commandeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new CommandeList();
        bean.setCommandeManager(commandeManager);

        // add a test commande to the database
        Commande commande = new Commande();

        // enter all required fields

        commandeManager.save(commande);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllCommandes() throws Exception {
        assertTrue(bean.getCommandes().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        commandeManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getCommandes().size());
    }
}