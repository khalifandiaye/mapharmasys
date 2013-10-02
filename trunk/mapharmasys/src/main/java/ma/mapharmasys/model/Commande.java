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
import javax.persistence.Transient;

import ma.mapharmasys.Constants.TypeVente;
import ma.mapharmasys.util.CommonUtil;
import ma.mapharmasys.util.DateUtil;

@Entity
@Table(name = "commande")
public class Commande extends BaseObject{
	
	private static final long serialVersionUID = 3725892799067871594L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="commande_id")
	private Long id;
	
	/**
	 * numero de commande (utiliser pour effectuer une facture) 
	 * ordonne de maniere croissant
	 */
	@Column(name="reference_commande")
	private String reference;
	
	/**
	 * Commande validee
	 */
	@Column(name="valide")
	private boolean valide;
	
	/**
	 * Date de la commande
	 */
	@Column(name="date_commande")
	private Date dateCommande = Calendar.getInstance().getTime();
	
	
	@Column(name="montant_total")
	private Double montantTotal;
	
	/**
	 * Type de vente normale, facture ou credit
	 */
	@Column(name="type_vente")
	private TypeVente typeVente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id", nullable = true)
	private Client client = new Client();
	
	@OneToMany(mappedBy = "commande", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval=true, fetch = FetchType.EAGER)
	private List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
	
	/*
	 * Constructors
	 */
	
	public Commande() {
		super();
	}
	
	public Commande(String reference, Date dateCommande, Double montantTotal, int nbrMedicamentTotal,
			TypeVente typeVente, Client client) {
		super();
		this.setReference(reference);
		this.dateCommande = dateCommande;
		this.montantTotal = montantTotal;
		this.typeVente = typeVente;
		this.client = client;
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

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Date getDateCommande() {
		return dateCommande;
	}
	
	@Transient
	public String getDateCommandeString() {
		return DateUtil.getDate(dateCommande, "dd/MM/yyyy HH:mm");
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public TypeVente getTypeVente() {
		return typeVente;
	}

	public void setTypeVente(TypeVente typeVente) {
		this.typeVente = typeVente;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	
	/*
	 * get montant total (la somme de tt les montant des lignes des commandes)
	 */
	public Double getMontantTotal() {
		montantTotal = 0d;
		for (LigneCommande ligneCommande : ligneCommandes) {
			montantTotal += ligneCommande.getMontant();
		}
		return CommonUtil.getDoubleValue(montantTotal);
	}

	public String getReference() {
		if (reference == null) {
			reference = CommonUtil.getReference();
		}
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
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
				+ ((dateCommande == null) ? 0 : dateCommande.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ligneCommandes == null) ? 0 : ligneCommandes.hashCode());
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		result = prime * result
				+ ((typeVente == null) ? 0 : typeVente.hashCode());
		result = prime * result + (valide ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", reference=" + reference + ", valide="
				+ valide + ", dateCommande=" + dateCommande + ", montantTotal="
				+ montantTotal + ", typeVente=" + typeVente + ", client="
				+ client + ", ligneCommandes=" + ligneCommandes + "]";
	}

}
