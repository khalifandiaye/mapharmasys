package ma.mapharmasys.service.impl;

import java.util.List;

import ma.mapharmasys.dao.MedicamentDao;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.MedicamentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of MedicamentManager interface.
 *
 */
@Service("medicamentManager")
public class MedicamentManagerImpl extends GenericManagerImpl<Medicament, Long> implements MedicamentManager {
    MedicamentDao medicamentDao;

    @Autowired
    public MedicamentManagerImpl(MedicamentDao medicamentDao) {
        super(medicamentDao);
        this.medicamentDao = medicamentDao;
    }

	@Override
	public List<Medicament> getMedicaments() {
		return medicamentDao.getMedicaments();
	}
}