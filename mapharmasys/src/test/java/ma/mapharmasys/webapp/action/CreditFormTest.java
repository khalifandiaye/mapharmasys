package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.CreditManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditFormTest extends BasePageTestCase {
    private CreditForm bean;
    @Autowired
    private CreditManager creditManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new CreditForm();
        bean.setCreditManager(creditManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Credit credit = new Credit();

        // enter all required fields
        bean.setCredit(credit);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getCredit());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getCredit());
        Credit credit = bean.getCredit();

        // update required fields
        bean.setCredit(credit);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Credit credit = new Credit();
        credit.setId(-2L);
        bean.setCredit(credit);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}