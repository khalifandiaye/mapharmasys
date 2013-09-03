package ma.mapharmasys.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name = "fournisseur")
public class Fournisseur extends BaseObject {

	private static final long serialVersionUID = -1240727648936067807L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fournisseur_id")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Embedded
	@IndexedEmbedded
	private Address addresse = new Address();
	
	@Column(name="telephone")
	private String telephone;
	
	/*
	 * Constructors
	 */

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Fournisseur(String nom, Address addresse, String telephone) {
		super();
		this.nom = nom;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
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
