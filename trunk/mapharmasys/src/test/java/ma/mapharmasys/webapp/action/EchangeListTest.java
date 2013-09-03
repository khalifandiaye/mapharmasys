package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.Constants.TypeEchange;
import ma.mapharmasys.model.Echange;
import ma.mapharmasys.service.EchangeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EchangeListTest extends BasePageTestCase {
    private EchangeList bean;
    @Autowired
    private EchangeManager echangeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new EchangeList();
        bean.setEchangeManager(echangeManager);

        // add a test echange to the database
        Echange echange = new Echange();

        // enter all required fields
        echange.setTypeEchange(TypeEchange.ENTREE);

        echangeManager.save(echange);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllEchanges() throws Exception {
        assertTrue(bean.getEchanges().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        echangeManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getEchanges().size());
    }
}