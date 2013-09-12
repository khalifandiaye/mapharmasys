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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "medicament")
@Indexed
public class Medicament extends BaseObject {
	
	private static final long serialVersionUID = -2076107571452868052L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medicament_id")
	private Long id;
	
	/**
	 * designation du medicament
	 */
	@Column(name = "designation", nullable = false, length=120)
    @Field
	private String libelle;
	
	/**
	 * prix unitaire de vente 
	 */
	@Column(name = "prix_unitaire", nullable = false)
    @Field
	private float prixUnit;
	
	/**
	 * prix unitaire d achat
	 */
	@Column(name = "prix_unitaire_achat")
    @Field
	private float prixAchat;
	
	/**
	 * la quantite du medicament presente dans le stock
	 */
	@Column(name = "quantite_stock")
    @Field
	private int nbrEnStock;
	
	/**
	 * le seuil bas de la quantite du medicament presente dans le stock
	 */
	@Column(name = "seuil_bas_stock")
    @Field
	private int lowEnStock;
	
	/**
	 * supression logique du medicament
	 */
	@Column(name = "supprime")
	private boolean deleted;
	
	/**
	 * le type du medicament
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="forme_id")
	private Forme forme = new Forme();
	
	
	/*
	 * Constructors
	 */
	
	public Medicament() {
		super();
	}
	
	public Medicament(String libelle, float prixUnit, float prixAchat,
			int nbrEnStock, int lowEnStock, boolean deleted) {
		super();
		this.libelle = libelle;
		this.prixUnit = prixUnit;
		this.prixAchat = prixAchat;
		this.nbrEnStock = nbrEnStock;
		this.lowEnStock = lowEnStock;
		this.deleted = deleted;
	}

	/*
	 * getters/setters
	 */
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnit() {
		return prixUnit;
	}

	public void setPrixUnit(float prixUnit) {
		this.prixUnit = prixUnit;
	}

	public float getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getNbrEnStock() {
		return nbrEnStock;
	}

	public void setNbrEnStock(int nbrEnStock) {
		this.nbrEnStock = nbrEnStock;
	}

	public int getLowEnStock() {
		return lowEnStock;
	}

	public void setLowEnStock(int lowEnStock) {
		this.lowEnStock = lowEnStock;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	public boolean isDeleted() {
		return deleted;
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
