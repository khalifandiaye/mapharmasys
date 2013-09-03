package ma.mapharmasys.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.mapharmasys.Constants.TypeEchange;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "echange")
public class Echange extends BaseObject {

	private static final long serialVersionUID = -6899331579403935730L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="echange_id")
	private Long id;
	
	/**
	 * date d echange
	 */
	@Column(name = "date_echange")
	@Field
	private Date dateEchange;
	
	/**
	 * valeur dechange = total prix achat des medicament dans l echange
	 */
	@Column(name="valeur_echange")
	private float valeurTotal;
	
	/**
	 * nbr de medicament dans l echange
	 */
	@Column(name="quantite_medicament")
	private int qteMedicament;
	
	/**
	 * liste detail echange
	 */
//	@OneToMany(mappedBy = "detailEchange", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	private Set<DetailEchange> detailEchanges = new HashSet<DetailEchange>();
	
	/**
	 * pharmacie concernee par lechange
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pharmacie_id")
	private Pharmacie pharmacie;
	
	@Column(name = "type_echange", nullable = false)
	private TypeEchange typeEchange;
	
	/*
	 * COnstructors
	 */
	public Echange() {
		super();
	}

	public Echange(Set<Medicament> medicaments, Pharmacie pharmacie,
			TypeEchange typeEchange) {
		super();
		this.pharmacie = pharmacie;
		this.typeEchange = typeEchange;
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

	public void setDateEchange(Date dateEchange) {
		this.dateEchange = dateEchange;
	}

	public Date getDateEchange() {
		return dateEchange;
	}

	public void setValeurTotal(float valeurTotal) {
		this.valeurTotal = valeurTotal;
	}

	public float getValeurTotal() {
		return valeurTotal;
	}

	public void setQteMedicament(int qteMedicament) {
		this.qteMedicament = qteMedicament;
	}

	public int getQteMedicament() {
		return qteMedicament;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public TypeEchange getTypeEchange() {
		return typeEchange;
	}

	public void setTypeEchange(TypeEchange typeEchange) {
		this.typeEchange = typeEchange;
	}

//	public void setDetailEchanges(Set<DetailEchange> detailEchanges) {
//		this.detailEchanges = detailEchanges;
//	}
//
//	public Set<DetailEchange> getDetailEchanges() {
//		return detailEchanges;
//	}

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
