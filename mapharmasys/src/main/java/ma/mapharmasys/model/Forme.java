package ma.mapharmasys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;

/**
 * Forme presente le type du medicament
 * @author belkhadir
 *
 */

@Entity
@Table(name = "forme")
public class Forme extends BaseObject{
	
	private static final long serialVersionUID = -3209840983222991839L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="forme_id")
	private Long id;
	
	@Column(name = "type_medicament", nullable = false, length=50)
	private String libelle;
	
	@Column(name="coefficient_prix_vente")
	private float coefficient;
	
	/*
	 * Constructors
	 */
	
	public Forme() {
		super();
	}
	
	public Forme(String libelle) {
		super();
		this.libelle = libelle;
	}

	/*
	 * getters/setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
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
