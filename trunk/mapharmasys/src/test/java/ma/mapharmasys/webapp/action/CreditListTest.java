package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.CreditManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditListTest extends BasePageTestCase {
    private CreditList bean;
    @Autowired
    private CreditManager creditManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new CreditList();
        bean.setCreditManager(creditManager);

        // add a test credit to the database
        Credit credit = new Credit();

        // enter all required fields

        creditManager.save(credit);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllCredits() throws Exception {
        assertTrue(bean.getCredits().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        creditManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getCredits().size());
    }
}