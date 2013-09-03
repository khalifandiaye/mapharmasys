package ma.mapharmasys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bon_livraison")
public class BonLivraison extends BaseObject {

	private static final long serialVersionUID = 362662907686499171L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bon_livraison_id")
	private Long id;
	
	@Column(name="date_facturation")
	private Date dateFacturation;
	
	@Column(name="montant_factural")
	private float montantFactural;
	
	@Column(name="num_doc")
	private int numDoc;
	
	@Column(name="heure_debut")
	private Date heureDebut;
	
	@Column(name="heure_fin")
	private Date heureFin;

	/*
	 * Constructors
	 */
	public BonLivraison() {
		super();
	}

	
	public BonLivraison(Date dateFacturation, float montantFactural,
			int numDoc, Date heureDebut, Date heureFin) {
		super();
		this.dateFacturation = dateFacturation;
		this.montantFactural = montantFactural;
		this.numDoc = numDoc;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
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

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public float getMontantFactural() {
		return montantFactural;
	}

	public void setMontantFactural(float montantFactural) {
		this.montantFactural = montantFactural;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
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
