package ma.mapharmasys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String heureDebut;
	
	@Column(name="heure_fin")
	private String heureFin;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fournisseur_id")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "bonLivraison", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<LigneBonLivraison> ligneBonLivraisons = new ArrayList<LigneBonLivraison>();
	
	/*
	 * Constructors
	 */
	public BonLivraison() {
		super();
	}

	
	public BonLivraison(Date dateFacturation, float montantFactural,
			int numDoc, String heureDebut, String heureFin) {
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

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public List<LigneBonLivraison> getLigneBonLivraisons() {
		return ligneBonLivraisons;
	}


	public void setLigneBonLivraisons(List<LigneBonLivraison> ligneBonLivraisons) {
		this.ligneBonLivraisons = ligneBonLivraisons;
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
