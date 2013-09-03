package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.BonLivraison;
import ma.mapharmasys.service.BonLivraisonManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BonLivraisonListTest extends BasePageTestCase {
    private BonLivraisonList bean;
    @Autowired
    private BonLivraisonManager bonLivraisonManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new BonLivraisonList();
        bean.setBonLivraisonManager(bonLivraisonManager);

        // add a test bonLivraison to the database
        BonLivraison bonLivraison = new BonLivraison();

        // enter all required fields

        bonLivraisonManager.save(bonLivraison);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllBonLivraisons() throws Exception {
        assertTrue(bean.getBonLivraisons().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        bonLivraisonManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getBonLivraisons().size());
    }
}