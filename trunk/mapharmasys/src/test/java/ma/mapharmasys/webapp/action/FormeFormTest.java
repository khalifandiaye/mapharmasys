package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Forme;
import ma.mapharmasys.service.FormeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FormeFormTest extends BasePageTestCase {
    private FormeForm bean;
    @Autowired
    private FormeManager formeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new FormeForm();
        bean.setFormeManager(formeManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Forme forme = new Forme();

        // enter all required fields
        forme.setLibelle("ThQsCzDaZoGaAxBeEaZdQmHxXsCdXyJqPfPwCdAtQdGeNeXxOr");
        bean.setForme(forme);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getForme());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getForme());
        Forme forme = bean.getForme();

        // update required fields
        forme.setLibelle("TnMxNuGdTdNaLqWeAoIjGvBgYpDtUjLvRpFpHgCaClOrZrFmKh");
        bean.setForme(forme);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Forme forme = new Forme();
        forme.setId(-2L);
        bean.setForme(forme);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}