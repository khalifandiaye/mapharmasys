package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Fournisseur;
import ma.mapharmasys.service.FournisseurManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FournisseurFormTest extends BasePageTestCase {
    private FournisseurForm bean;
    @Autowired
    private FournisseurManager fournisseurManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new FournisseurForm();
        bean.setFournisseurManager(fournisseurManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Fournisseur fournisseur = new Fournisseur();

        // enter all required fields
        bean.setFournisseur(fournisseur);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getFournisseur());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getFournisseur());
        Fournisseur fournisseur = bean.getFournisseur();

        // update required fields
        bean.setFournisseur(fournisseur);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(-2L);
        bean.setFournisseur(fournisseur);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}