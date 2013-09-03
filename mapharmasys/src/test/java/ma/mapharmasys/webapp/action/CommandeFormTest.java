package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.service.CommandeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandeFormTest extends BasePageTestCase {
    private CommandeForm bean;
    @Autowired
    private CommandeManager commandeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new CommandeForm();
        bean.setCommandeManager(commandeManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Commande commande = new Commande();

        // enter all required fields
        bean.setCommande(commande);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getCommande());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getCommande());
        Commande commande = bean.getCommande();

        // update required fields
        bean.setCommande(commande);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Commande commande = new Commande();
        commande.setId(-2L);
        bean.setCommande(commande);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}