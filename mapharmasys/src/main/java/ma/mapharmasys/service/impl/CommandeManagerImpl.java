package ma.mapharmasys.service.impl;

import ma.mapharmasys.dao.CommandeDao;
import ma.mapharmasys.dao.MedicamentDao;
import ma.mapharmasys.model.Commande;
import ma.mapharmasys.model.Medicament;
import ma.mapharmasys.service.CommandeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of FormeManager interface.
 *
 */
@Service("commandeManager")
public class CommandeManagerImpl extends GenericManagerImpl<Commande, Long> implements CommandeManager {
	private CommandeDao commandeDao;
	private MedicamentDao medicamentDao;
	

    @Autowired
    public CommandeManagerImpl(CommandeDao commandeDao) {
        super(commandeDao);
        this.commandeDao = commandeDao;
    }

	@Override
	public Long getLastNumero() {
		return commandeDao.getLastNumero();
	}

	@Override
	public void validateCommande(Long commandeId) {
		Commande commande = get(commandeId);
		if (commande != null && !commande.isValide()) {
			Medicament medicament = null;
//			for (LigneCommande lc : commande.getLigneCommandes()) {
//				medicament = lc.getMedicament();
//				medicament.setNbrEnStock(medicament.getNbrEnStock() - lc.getNbrMedicament());
//				medicamentDao.save(medicament);
//			}
		}
		
		commandeDao.validateCommande(commandeId); 	
	}


	@Autowired
	public void setMedicamentDao(MedicamentDao medicamentDao) {
		this.medicamentDao = medicamentDao;
	}
}