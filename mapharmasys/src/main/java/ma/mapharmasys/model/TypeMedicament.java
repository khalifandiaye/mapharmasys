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
@Table(name = "type_medicament")
public class TypeMedicament extends BaseObject{
	
	private static final long serialVersionUID = -3209840991839L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_medicament_id")
	private Long id;
	
	@Column(name = "libelle", nullable = false, length=50)
	private String libelle;
	
	
	/*
	 * Constructors
	 */
	
	public TypeMedicament() {
		super();
	}
	
	public TypeMedicament(String libelle) {
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
