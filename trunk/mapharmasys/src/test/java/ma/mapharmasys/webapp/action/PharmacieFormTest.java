package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Pharmacie;
import ma.mapharmasys.service.PharmacieManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PharmacieFormTest extends BasePageTestCase {
    private PharmacieForm bean;
    @Autowired
    private PharmacieManager pharmacieManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new PharmacieForm();
        bean.setPharmacieManager(pharmacieManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Pharmacie pharmacie = new Pharmacie();

        // enter all required fields
        pharmacie.setNomPharmacie("DgYvMmHhFpXiPnWhViQwJwLuPhSyBgCbHcDpBoKlMrUoStXeAr");
        pharmacie.setTelephone("QqAjUuDbOgZsGzL");
        bean.setPharmacie(pharmacie);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getPharmacie());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getPharmacie());
        Pharmacie pharmacie = bean.getPharmacie();

        // update required fields
        pharmacie.setNomPharmacie("QeFeWaQhOdOqLsRtSkDfZkXaEzBpJuQdQkTmDwHvIqOjEjFqJg");
        pharmacie.setTelephone("SjDzWxYxSoXmNcN");
        bean.setPharmacie(pharmacie);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Pharmacie pharmacie = new Pharmacie();
        pharmacie.setId(-2L);
        bean.setPharmacie(pharmacie);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}