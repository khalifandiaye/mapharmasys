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
	
	/*
	 * Constructors
	 */
	
	public Credit() {
		super();
	}
	
	public Credit(Date dateCredit, Client client, Commande commande) {
		super();
		this.dateCredit = dateCredit;
		this.client = client;
		this.commande = commande;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result
				+ ((commande == null) ? 0 : commande.hashCode());
		result = prime * result
				+ ((dateCredit == null) ? 0 : dateCredit.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", dateCredit=" + dateCredit + ", client="
				+ client + ", commande=" + commande + "]";
	}
}
