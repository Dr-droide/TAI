import java.util.*;

public class AffectationBeanModele {
	private int id;
	private String nom;
	private String description;
	private String date_debut;
	private String date_fin;
	private boolean emargement;
	private UserBeanModele user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEmargement() {
		return emargement;
	}
	public void setEmargement(boolean emargement) {
		this.emargement = emargement;
	}
	public UserBeanModele getUser() {
		return user;
	}
	public void setUser(UserBeanModele user) {
		this.user = user;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	


	
	
		
}
