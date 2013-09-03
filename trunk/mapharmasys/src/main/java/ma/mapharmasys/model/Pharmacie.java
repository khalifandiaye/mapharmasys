package ma.mapharmasys.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name = "pharmacie")
public class Pharmacie extends BaseObject {

	private static final long serialVersionUID = -552764425253312214L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pharmacie_id")
	private Long id;
	
	/**
	 * nom de la pharmacie
	 */
	@Column(name = "nom", nullable = false, length=50)
	private String nomPharmacie;
	
	/**
	 * adresse de la pharmacie
	 */
	@Embedded
    @IndexedEmbedded
	private Address addresse = new Address();
	
	/**
	 * telephone de la pharmacie
	 */
	@Column(name = "telephone", nullable = false, length=15)
	private String telephone;
	
	/*
	 * Constructors
	 */
	
	public Pharmacie() {
		super();
	}

	public Pharmacie(String nomPharmacie, Address addresse, String telephone) {
		super();
		this.nomPharmacie = nomPharmacie;
		this.addresse = addresse;
		this.telephone = telephone;
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

	public String getNomPharmacie() {
		return nomPharmacie;
	}

	public void setNomPharmacie(String nomPharmacie) {
		this.nomPharmacie = nomPharmacie;
	}

	public Address getAddresse() {
		return addresse;
	}

	public void setAddresse(Address addresse) {
		this.addresse = addresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
