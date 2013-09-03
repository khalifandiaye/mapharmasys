package ma.mapharmasys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ma.mapharmasys.Constants.TypeVente;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Entity
@Table(name = "commande")
public class Commande extends BaseObject{
	
	private static final long serialVersionUID = 3725892799067871594L;
	private static final Log LOG = LogFactory.getLog(Commande.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="commande_id")
	private Long id;
	
	/**
	 * numero de commande (utiliser pour effectuer une facture) 
	 * ordonne de maniere croissant
	 */
	@Column(name="numero_commande")
	private Long numero;
	
	/**
	 * Commande validee
	 */
	@Column(name="valide")
	private boolean valide;
	
	/**
	 * Date de la commande
	 */
	@Column(name="date_commande")
	private Date dateCommande;
	
	/**
	 * heure de la commande
	 */
	@Column(name="heure")
	private String heure;
	
	/**
	 * minute de la commande
	 */
	@Column(name="minute")
	private String minute;
	
	@Column(name="montant_total")
	private float montantTotal;
	
	@Column(name="nbr_medicament")
	private int nbrMedicamentTotal;
	
	/**
	 * Type de vente normale, facture ou credit
	 */
	@Column(name="type_vente")
	private TypeVente typeVente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id", nullable= true)
	private Client client;
	
//	@Transient
//	private List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
	
//	@OneToMany(mappedBy = "commande", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	private List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
	
	/*
	 * Constructors
	 */
	
	public Commande() {
		super();
	}
	
	public Commande(Long numero, Date dateCommande, float montantTotal, int nbrMedicamentTotal,
			TypeVente typeVente, Client client) {
		super();
		this.setNumero(numero);
		this.dateCommande = dateCommande;
		this.montantTotal = montantTotal;
		this.nbrMedicamentTotal = nbrMedicamentTotal;
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

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getNumero() {
		return numero;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
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

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

//	public float getMontantTotal() {
//		return getMontantTotal(ligneCommandes);
//	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

//	public int getNbrMedicamentTotal() {
//		return getNbrTotalMedicamnt(ligneCommandes);
//	}

	public void setNbrMedicamentTotal(int nbrMedicamentTotal) {
		this.nbrMedicamentTotal = nbrMedicamentTotal;
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

//	public Set<LigneCommande> getLigneCommandes() {
//		return ligneCommandes;
//	}
//
//	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
//		this.ligneCommandes = ligneCommandes;
//	}

//	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
//		this.ligneCommandes = ligneCommandes;
//	}
//
//	public List<LigneCommande> getLigneCommandes() {
//		return ligneCommandes;
//	}
//	
//	public void addLigneCommande(LigneCommande ligneCommande){
//		LOG.info("[Commande] Add ligne commande > Entring ...");
//		if (ligneCommandes == null)
//			ligneCommandes = new ArrayList<LigneCommande>();
//		
//		LOG.info("[Commande] Add ligne commande > ligneCommandes size : " + ligneCommandes.size());
//		if (!ligneCommandes.contains(ligneCommande)) {
//			ligneCommandes.add(ligneCommande);
//			LOG.info("[Commande] Add ligne commande > ligneCommande added : " + ligneCommande);
//		}else
//			LOG.info("[Commande] Add ligne commande > ligneCommande already exist : " + ligneCommande);
//	}
	
	/*
	 * get montant total (la somme de tt les montant des lignes des commandes)
	 */
    private float getMontantTotal(List<LigneCommande> listeLCs) {
		float montantTotal = 0f;
		for (LigneCommande ligneCommande : listeLCs) {
			montantTotal += ligneCommande.getMontant();
		}
		return montantTotal;
	}

    /*
     * get nombre medicament total (la somme de tt les medcament dans les lignes de commandes)
     */
	private int getNbrTotalMedicamnt(List<LigneCommande> listeLCs) {
		int nbrMedicament = 0;
		for (LigneCommande ligneCommande : listeLCs) {
			nbrMedicament += ligneCommande.getNbrMedicament();
		}
		return nbrMedicament;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("CommandeId", this.id)
				.append("Numero", this.numero).toString();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }

        final Commande commande = (Commande) o;

        return !(this.id != null ? !this.id.equals(commande.getId()) : commande.getId() != null);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
