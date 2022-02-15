
public class ContratBeanModele {
	private int id;
	private UserBeanModele user;
	private double nb_heure;
	private double salaire_horaire;
	private FonctionBeanModele fonction;
	private CategorieBeanModele categorie;
	private EchelonBeanModele echelon;
	private DepartementBeanModele departement;	
	private String date_embauche;
	//dzd
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public double getSalaire_horaire() {
		return salaire_horaire;
	}
	public void setSalaire_horaire(double salaire_horaire) {
		this.salaire_horaire = salaire_horaire;
	}
	public FonctionBeanModele getFonction() {
		return fonction;
	}
	public void setFonction(FonctionBeanModele fonction) {
		this.fonction = fonction;
	}
	public CategorieBeanModele getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieBeanModele categorie) {
		this.categorie = categorie;
	}
	public EchelonBeanModele getEchelon() {
		return echelon;
	}
	public void setEchelon(EchelonBeanModele echelon) {
		this.echelon = echelon;
	}
	public DepartementBeanModele getDepartement() {
		return departement;
	}
	public void setDepartement(DepartementBeanModele departement) {
		this.departement = departement;
	}
	public String getDate_embauche() {
		return date_embauche;
	}
	public void setDate_embauche(String date_embauche) {
		this.date_embauche = date_embauche;
	}
	public UserBeanModele getUser() {
		return user;
	}
	public void setUser(UserBeanModele user) {
		this.user = user;
	}
	public double getNb_heure() {
		return nb_heure;
	}
	public void setNb_heure(double nb_heure) {
		this.nb_heure = nb_heure;
	}
	

}
