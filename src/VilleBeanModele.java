
public class VilleBeanModele {
	private int id;
	private String nom;
	private String bp;
	private PaysBeanModele pays;	
	
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
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public PaysBeanModele getPays() {
		return pays;
	}
	public void setPays(PaysBeanModele pays) {
		this.pays = pays;
	}
		
}
