package ma.mapharmasys.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ma.mapharmasys.util.CommonUtil;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "client")
public class Client extends BaseObject {

	private static final long serialVersionUID = 6696443542727618987L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Long id;

	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;

	@Column(name = "cin", length = 15)
	private String cin;

	@Column(name = "telephone", length = 15)
	private String telephone;

	@Column(name = "total_credit")
	private Double totalCredit;

	@Column(name = "total_avance")
	private Double totalAvance;

	@Column(name = "total_reste")
	private Double totalReste;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH }, orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Credit> credits = new ArrayList<Credit>();

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH }, orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Avance> avances = new ArrayList<Avance>();

	/*
	 * Constructors
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

	/**
	 * Returns the full name.
	 * 
	 * @return firstName + ' ' + lastName
	 */
	@Transient
	public String getFullName() {
		StringBuilder builder = new StringBuilder();
		builder.append(prenom != null ? prenom : "");
		builder.append((prenom != null && nom != null) ? " " : "");
		builder.append(nom != null ? nom : "");
		return builder.toString();
	}

	public Double getTotalCredit() {
		totalCredit = 0d;
		if (credits != null && !credits.isEmpty()) {
			for (Credit credit : credits) {
				totalCredit += credit.getCommande().getMontantTotal();
			}
		}
		return CommonUtil.getDoubleValue(totalCredit);
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Double getTotalAvance() {
		totalAvance = 0d;
		if(avances != null && !avances.isEmpty()){
			for (Avance avance : avances) {
				totalAvance += avance.getAvance();
			}
		}
		return CommonUtil.getDoubleValue(totalAvance);
	}

	public void setTotalAvance(Double totalAvance) {
		this.totalAvance = totalAvance;
	}

	public Double getTotalReste() {
		totalReste = getTotalCredit() - getTotalAvance();
		return CommonUtil.getDoubleValue(totalReste);
	}

	public void setTotalReste(Double totalReste) {
		this.totalReste = totalReste;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public List<Avance> getAvances() {
		return avances;
	}

	public void setAvances(List<Avance> avances) {
		this.avances = avances;
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
