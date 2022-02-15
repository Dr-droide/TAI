import java.time.Year;

public class FichePaieBeanModele {
	private int id;
	private UserBeanModele user;
	private MoisBeanModele mois;
	private Year year; 
	private ContratBeanModele contrat;
	private double heureOuvre;
	
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
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public ContratBeanModele getContrat() {
		return contrat;
	}
	public void setContrat(ContratBeanModele contrat) {
		this.contrat = contrat;
	}
	public double getHeureOuvre() {
		return heureOuvre;
	}
	public void setHeureOuvre(double heureOuvre) {
		this.heureOuvre = heureOuvre;
	}

}
