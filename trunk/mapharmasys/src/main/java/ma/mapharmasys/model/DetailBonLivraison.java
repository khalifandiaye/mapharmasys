package ma.mapharmasys.model;

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
@Table(name = "detail_bon_livraison")
public class DetailBonLivraison extends BaseObject {

	private static final long serialVersionUID = -5225930009231708073L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="detail_bon_livraison_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medicament_id", nullable=false)
	private Medicament medicament;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bon_livraison_id", nullable=false)
	private BonLivraison bonLivraison;
	
	@Column(name="quantite")
	private int qte;
	
	/*
	 * COnstructors
	 */
	public DetailBonLivraison() {
		super();
	}

	public DetailBonLivraison(Medicament medicament, BonLivraison bonLivraison,
			int qte) {
		super();
		this.medicament = medicament;
		this.bonLivraison = bonLivraison;
		this.qte = qte;
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

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public BonLivraison getBonLivraison() {
		return bonLivraison;
	}

	public void setBonLivraison(BonLivraison bonLivraison) {
		this.bonLivraison = bonLivraison;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
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
