package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.TypeMedicamentDao;
import ma.mapharmasys.model.TypeMedicament;
import ma.mapharmasys.service.TypeMedicamentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("typeMedicamentManager")
public class TypeMedicamentManagerImpl extends GenericManagerImpl<TypeMedicament, Long> implements TypeMedicamentManager {
    TypeMedicamentDao typeMedicamentDao;

    @Autowired
    public TypeMedicamentManagerImpl(TypeMedicamentDao typeMedicamentDao) {
        super(typeMedicamentDao);
        this.typeMedicamentDao = typeMedicamentDao;
    }
}