package ma.mapharmasys.util;

import ma.mapharmasys.model.Medicament;

public class MedicamentBean {

	private Medicament medicament = new Medicament();
	private int qte;

	public MedicamentBean() {
		super();
	}

	public MedicamentBean(Medicament medicament, int qte) {
		super();
		this.medicament = medicament;
		this.qte = qte;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

}
