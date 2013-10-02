package ma.mapharmasys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_echange")
public class DetailEchange extends BaseObject {
	
	private static final long serialVersionUID = 3735031546819706329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="detail_echange_id")
	private Long id;
	
	/**
	 * medicament dechange
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medicament_id")
	private Medicament medicament;
	
	/**
	 * echange concvernee
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="echange_id")
	private Echange echange;
	
	/**
	 * quantite medicament
	 */
	@Column(name="quantite_detail_echange")
	private int qteMedicament;
	
	/**
	 * valeur = la somme des prix d'achat de medicament
	 */
	@Column(name="valeur_detail_echange")
	private float valeur;
	
	/*
	 * Constructors
	 */
	public DetailEchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailEchange(Medicament medicament, Echange echange,
			int qteMedicament, float valeur) {
		super();
		this.medicament = medicament;
		this.echange = echange;
		this.qteMedicament = qteMedicament;
		this.valeur = valeur;
	}
	
	public DetailEchange(Medicament medicament, int qteMedicament) {
		super();
		this.medicament = medicament;
		this.qteMedicament = qteMedicament;
	}

	/*
	 * getters/setter
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Echange getEchange() {
		return echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

	public int getQteMedicament() {
		return qteMedicament;
	}

	public void setQteMedicament(int qteMedicament) {
		this.qteMedicament = qteMedicament;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
