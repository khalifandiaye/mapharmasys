package ma.mapharmasys.model;

import java.util.Date;

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
@Table(name = "credit")
public class Credit extends BaseObject {

	private static final long serialVersionUID = -8301124312340298942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="credit_id")
	private Long id;
	
	@Column(name="date_dredit")
	private Date dateCredit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id", nullable=false)
	private Client client;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="commande_id", nullable=false)
	private Commande commande;
	
	@Column(name="avance")
	private float avance;
	
	@Column(name="reste")
	private float reste;
	
	/*
	 * Constructors
	 */
	
	public Credit() {
		super();
	}
	
	public Credit(Date dateCredit, Client client, Commande commande,
			float avance, float reste) {
		super();
		this.dateCredit = dateCredit;
		this.client = client;
		this.commande = commande;
		this.avance = avance;
		this.reste = reste;
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


	public Date getDateCredit() {
		return dateCredit;
	}


	public void setDateCredit(Date dateCredit) {
		this.dateCredit = dateCredit;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public float getAvance() {
		return avance;
	}


	public void setAvance(float avance) {
		this.avance = avance;
	}


	public float getReste() {
		return reste;
	}


	public void setReste(float reste) {
		this.reste = reste;
	}


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
