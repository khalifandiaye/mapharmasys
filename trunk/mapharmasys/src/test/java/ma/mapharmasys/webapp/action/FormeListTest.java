package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Forme;
import ma.mapharmasys.service.FormeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FormeListTest extends BasePageTestCase {
    private FormeList bean;
    @Autowired
    private FormeManager formeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new FormeList();
        bean.setFormeManager(formeManager);

        // add a test forme to the database
        Forme forme = new Forme();

        // enter all required fields
        forme.setLibelle("AlBwWzCwNlYzWaYhQsPaFxNvLbEyJcBfIwTnFbJmNyFtFsAsTg");

        formeManager.save(forme);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllFormes() throws Exception {
        assertTrue(bean.getFormes().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        formeManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getFormes().size());
    }
}