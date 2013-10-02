package ma.mapharmasys.model;

import java.util.Calendar;
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
@Table(name = "avance")
public class Avance extends BaseObject {

	private static final long serialVersionUID = -830298942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="avance_id")
	private Long id;
	
	@Column(name="date_avance")
	private Date dateAvance = Calendar.getInstance().getTime();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id", nullable=false)
	private Client client;
	
	@Column(name="avance")
	private float avance;
	
	/*
	 * Constructors
	 */
	
	public Avance() {
		super();
	}
	
	public Avance(Date dateAvance, Client client, Commande commande,
			float avance, float reste) {
		super();
		this.dateAvance = dateAvance;
		this.client = client;
		this.avance = avance;
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


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public float getAvance() {
		return avance;
	}


	public void setAvance(float avance) {
		this.avance = avance;
	}

	public Date getDateAvance() {
		return dateAvance;
	}

	public void setDateAvance(Date dateAvance) {
		this.dateAvance = dateAvance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(avance);
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result
				+ ((dateAvance == null) ? 0 : dateAvance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avance other = (Avance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Avance [id=" + id + ", dateAvance=" + dateAvance + ", client="
				+ client + ", avance=" + avance + "]";
	}

}
