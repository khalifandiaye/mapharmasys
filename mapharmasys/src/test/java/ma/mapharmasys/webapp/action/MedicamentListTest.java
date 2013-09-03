package ma.mapharmasys.webapp.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicamentListTest extends BasePageTestCase {
    private MedicamentList bean;
    @Autowired
    private MedicamentManager medicamentManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        bean = new MedicamentList();
        bean.setMedicamentManager(medicamentManager);

        // add a test medicament to the database
        Medicament medicament = new Medicament();

        // enter all required fields
        medicament.setLibelle("WvVkOdSnDiOsGpJuMyEoTqYlWuBkLdOdKkOlKuJcUjPwXzVqBkHqXrXkAkUbItLiPqHpGeYbAaXaHbDiQxBqNfNvFmEyAiQaLwBcOyWiOcPfNvLyXnVwJaVn");
        medicament.setPrixUnit(new Float(3.2405E38));

        medicamentManager.save(medicament);
    }

    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testGetAllMedicaments() throws Exception {
        assertTrue(bean.getMedicaments().size() >= 1);
        assertFalse(bean.hasErrors());
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        medicamentManager.reindex();

        bean.setQuery("*");
        assertEquals("success", bean.search());
        assertEquals(4, bean.getMedicaments().size());
    }
}