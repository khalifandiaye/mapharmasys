package ma.mapharmasys.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name = "client")
public class Client extends BaseObject {

	private static final long serialVersionUID = 6696443542727618987L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private Long id;
	
	@Column(name="nom", length=50)
	private String nom;
	
	@Column(name="prenom", length=50)
	private String prenom;
	
	@Column(name="cin", length=15)
	private String cin;
	
	@Column(name="telephone", length=15)
	private String telephone;
	
	@Embedded
	@IndexedEmbedded
	private Address addresse = new Address();

	/*
	 * COnstrictors
	 */
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String cin, String telephone,
			Address addresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
		this.addresse = addresse;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Address getAddresse() {
		return addresse;
	}

	public void setAddresse(Address addresse) {
		this.addresse = addresse;
	}
	
	/**
     * Returns the full name.
     *
     * @return firstName + ' ' + lastName
     */
    @Transient
    public String getFullName() {
        return prenom != null ? prenom : "" + ' ' + nom != null ? nom : "";
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
