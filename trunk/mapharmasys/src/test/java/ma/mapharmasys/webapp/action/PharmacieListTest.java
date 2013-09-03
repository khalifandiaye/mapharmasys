package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.PharmacieManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PharmacieListTest extends BasePageTestCase {
    private PharmacieList bean;
    @Autowired
    private PharmacieManager pharmacieManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new PharmacieList();
        bean.setPharmacieManager(pharmacieManager);

        // add a test pharmacie to the database
        Pharmacie pharmacie = new Pharmacie();

        // enter all required fields
        pharmacie.setNomPharmacie("FxEfGgLeFpDdFtFdJqRtZqMwBcRsYaUjCzGuNpEkBkOwAiCqKw");
        pharmacie.setTelephone("CtFfHoIsPhDqJhW");

        pharmacieManager.save(pharmacie);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllPharmacies() throws Exception {
        assertTrue(bean.getPharmacies().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        pharmacieManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getPharmacies().size());
    }
}