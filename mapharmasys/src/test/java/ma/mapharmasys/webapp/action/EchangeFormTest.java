package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.Constants.TypeEchange;
import ma.mapharmasys.model.Echange;
import ma.mapharmasys.service.EchangeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EchangeFormTest extends BasePageTestCase {
    private EchangeForm bean;
    @Autowired
    private EchangeManager echangeManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new EchangeForm();
        bean.setEchangeManager(echangeManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Echange echange = new Echange();

        // enter all required fields
        echange.setTypeEchange(TypeEchange.ENTREE);
        bean.setEchange(echange);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getEchange());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getEchange());
        Echange echange = bean.getEchange();

        // update required fields
        echange.setTypeEchange(TypeEchange.ENTREE);
        bean.setEchange(echange);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Echange echange = new Echange();
        echange.setId(-2L);
        bean.setEchange(echange);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}