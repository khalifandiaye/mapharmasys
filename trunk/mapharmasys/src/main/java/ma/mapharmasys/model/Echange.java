package ma.mapharmasys.model;

import java.util.ArrayList;
import java.util.Calendar;
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
	private Date dateEchange = Calendar.getInstance().getTime();
	
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
	 * pharmacie concernee par lechange
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pharmacie_id")
	private Pharmacie pharmacie = new Pharmacie();
	
	@Column(name = "type_echange", nullable = false)
	private TypeEchange typeEchange;
	
	@OneToMany(mappedBy = "echange", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval=true, fetch = FetchType.EAGER)
	private List<DetailEchange> detailEchanges = new ArrayList<DetailEchange>();
	
	/*
	 * COnstructors
	 */
	public Echange() {
		super();
	}

	public Echange(Pharmacie pharmacie,
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

	public List<DetailEchange> getDetailEchanges() {
		return detailEchanges;
	}

	public void setDetailEchanges(List<DetailEchange> detailEchanges) {
		this.detailEchanges = detailEchanges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEchange == null) ? 0 : dateEchange.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pharmacie == null) ? 0 : pharmacie.hashCode());
		result = prime * result + qteMedicament;
		result = prime * result
				+ ((typeEchange == null) ? 0 : typeEchange.hashCode());
		result = prime * result + Float.floatToIntBits(valeurTotal);
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
		Echange other = (Echange) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Echange [id=" + id + ", dateEchange=" + dateEchange
				+ ", valeurTotal=" + valeurTotal + ", qteMedicament="
				+ qteMedicament + ", pharmacie=" + pharmacie + ", typeEchange="
				+ typeEchange + "]";
	}
}
