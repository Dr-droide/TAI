import java.time.Year;
//dzd
public class FichePaieBeanModele {
	private int id;
	private UserBeanModele user;
	private MoisBeanModele mois;
	private int annee; 
	private ContratBeanModele contrat;
	private double heure_ouvre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBeanModele getUser() {
		return user;
	}
	public void setUser(UserBeanModele user) {
		this.user = user;
	}
	public MoisBeanModele getMois() {
		return mois;
	}
	public void setMois(MoisBeanModele mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public ContratBeanModele getContrat() {
		return contrat;
	}
	public void setContrat(ContratBeanModele contrat) {
		this.contrat = contrat;
	}
	public double getHeure_ouvre() {
		return heure_ouvre;
	}
	public void setHeure_ouvre(double heure_ouvre) {
		this.heure_ouvre = heure_ouvre;
	}

}
