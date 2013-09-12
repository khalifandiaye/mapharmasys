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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "ligne_bon_livraison")
public class LigneBonLivraison extends BaseObject {

	private static final long serialVersionUID = 404963037944591091L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ligne_bon_livraison_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bon_livraison_id", nullable = false)
	private BonLivraison bonLivraison;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medicament_id", nullable = false)
	private Medicament medicament;
	
	@Column(name="nombre_medicament")
	private int nbrMedicament = 1;
	
	@Column(name="montant")
	private float montant;
	
	/*
	 * Constructors
	 */
	
	public LigneBonLivraison() {
		super();
	}
	
	public LigneBonLivraison(Long id, BonLivraison bonLivraison, Medicament medicament,
			int nbrMedicament, float montant) {
		super();
		this.id = id;
		this.bonLivraison = bonLivraison;
		this.medicament = medicament;
		this.nbrMedicament = nbrMedicament;
		this.montant = montant;
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

	public int getNbrMedicament() {
		return nbrMedicament;
	}

	public void setNbrMedicament(int nbrMedicament) {
		this.nbrMedicament = nbrMedicament;
	}

	public float getMontant() {
		return medicament.getPrixAchat() * nbrMedicament;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public BonLivraison getBonLivraison() {
		return bonLivraison;
	}

	public void setBonLivraison(BonLivraison bonLivraison) {
		this.bonLivraison = bonLivraison;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("LC id", this.id).toString();
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
