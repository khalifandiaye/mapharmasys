package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Fournisseur;
import ma.mapharmasys.service.FournisseurManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FournisseurListTest extends BasePageTestCase {
    private FournisseurList bean;
    @Autowired
    private FournisseurManager fournisseurManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new FournisseurList();
        bean.setFournisseurManager(fournisseurManager);

        // add a test fournisseur to the database
        Fournisseur fournisseur = new Fournisseur();

        // enter all required fields

        fournisseurManager.save(fournisseur);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllFournisseurs() throws Exception {
        assertTrue(bean.getFournisseurs().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        fournisseurManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getFournisseurs().size());
    }
}