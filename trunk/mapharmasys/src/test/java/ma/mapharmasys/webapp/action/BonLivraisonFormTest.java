package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.service.BonLivraisonManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BonLivraisonFormTest extends BasePageTestCase {
    private BonLivraisonForm bean;
    @Autowired
    private BonLivraisonManager bonLivraisonManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new BonLivraisonForm();
        bean.setBonLivraisonManager(bonLivraisonManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        BonLivraison bonLivraison = new BonLivraison();

        // enter all required fields
        bean.setBonLivraison(bonLivraison);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getBonLivraison());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getBonLivraison());
        BonLivraison bonLivraison = bean.getBonLivraison();

        // update required fields
        bean.setBonLivraison(bonLivraison);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        BonLivraison bonLivraison = new BonLivraison();
        bonLivraison.setId(-2L);
        bean.setBonLivraison(bonLivraison);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}