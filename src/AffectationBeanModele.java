import java.util.*;

public class AffectationBeanModele {
	private int id;
	private String nom;
	private String description;
	private java.sql.Date debutDate;
	private java.sql.Date finDate;
	private boolean emargement;
	private UserBeanModele IdUser;
		
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
	public java.sql.Date getDebutDate() {
		return debutDate;
	}
	public void setDebutDate(java.sql.Date debutDate) {
		this.debutDate = debutDate;
	}
	public java.sql.Date getFinDate() {
		return finDate;
	}
	public void setFinDate(java.sql.Date finDate) {
		this.finDate = finDate;
	}
	public boolean isEmargement() {
		return emargement;
	}
	public void setEmargement(boolean emargement) {
		this.emargement = emargement;
	}
	public UserBeanModele getIdUser() {
		return IdUser;
	}
	public void setIdUser(UserBeanModele idUser) {
		IdUser = idUser;
	}
		
}
