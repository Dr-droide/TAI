
public class UserBeanModele {
    private int id;
    private RoleBeanModele role;
    private String matricule;
    private String mdp;
    private String nom;
    private String prenom;
    private EtatCivilBeanModele etat_civil;
    private StatutMaritalBeanModele statut_marital;
    private int nb_enfant;
    private double heure_ouvre;
    private String adresse1;
    private String adresse2;
    private VilleBeanModele ville;

    UserBeanModele(){
        
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleBeanModele getRole() {
		return role;
	}

	public void setRole(RoleBeanModele role) {
		this.role = role;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public EtatCivilBeanModele getEtat_civil() {
		return etat_civil;
	}

	public void setEtat_civil(EtatCivilBeanModele etat_civil) {
		this.etat_civil = etat_civil;
	}

	public StatutMaritalBeanModele getStatut_marital() {
		return statut_marital;
	}

	public void setStatut_marital(StatutMaritalBeanModele statut_marital) {
		this.statut_marital = statut_marital;
	}

	public int getNb_enfant() {
		return nb_enfant;
	}

	public void setNb_enfant(int nb_enfant) {
		this.nb_enfant = nb_enfant;
	}

	public double getHeure_ouvre() {
		return heure_ouvre;
	}

	public void setHeure_ouvre(double heure_ouvre) {
		this.heure_ouvre = heure_ouvre;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public VilleBeanModele getVille() {
		return ville;
	}

	public void setVille(VilleBeanModele ville) {
		this.ville = ville;
	}

}
