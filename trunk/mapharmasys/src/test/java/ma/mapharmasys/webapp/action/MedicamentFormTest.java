package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicamentFormTest extends BasePageTestCase {
    private MedicamentForm bean;
    @Autowired
    private MedicamentManager medicamentManager;

    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new MedicamentForm();
        bean.setMedicamentManager(medicamentManager);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testAdd() throws Exception {
        Medicament medicament = new Medicament();

        // enter all required fields
        medicament.setLibelle("ZeZuGcKkBmHkFyIqKiCbNwUlLxHsDdYtJlXdEzMrFkZzUcMrHdNaYbXyDaJkWkDoDhNlZbNgCbSkLfToSyLtFtHwRvYhQqXnJaVlHoIvFaPsRbLbSsSqTsRu");
        medicament.setPrixUnit(new Float(1.3700199E38));
        bean.setMedicament(medicament);

        assertEquals("list", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getMedicament());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSave() {
        log.debug("testing save...");
        bean.setId(-1L);

        assertEquals("edit", bean.edit());
        assertNotNull(bean.getMedicament());
        Medicament medicament = bean.getMedicament();

        // update required fields
        medicament.setLibelle("SvYmPkFwUxNxBhOfUdDnVlNvRoFoZiWuXcKjSvRdIqMuCjDgIoQuQnRxVvOnCkRoUdLzNiFxZyLaGhDqIdRnLwAhOcShZcBbKpYaYkCyIeDgJdUdZaDlAzBz");
        medicament.setPrixUnit(new Float(3.1890327E38));
        bean.setMedicament(medicament);

        assertEquals("edit", bean.save());
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testRemove() throws Exception {
        log.debug("testing remove...");
        Medicament medicament = new Medicament();
        medicament.setId(-2L);
        bean.setMedicament(medicament);

        assertEquals("list", bean.delete());
        assertFalse(bean.hasErrors());
    }
}