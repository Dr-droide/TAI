
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class UserDAOModele {
 
	// CRUD: create(obj)
	public int creer(UserBeanModele user)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO user (id_role, matricule, mdp, nom, prenom, id_etat_civil, id_statut_marital, nb_enfant, heure_ouvre, adresse1, adresse2, id_ville) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, user.getRole().getId());
			statement.setString(2, user.getMatricule());
			statement.setString(3, user.getMdp());
			statement.setString(4, user.getNom());
			statement.setString(5, user.getPrenom());
			statement.setInt(6, user.getEtat_civil().getId());
			statement.setInt(7, user.getStatut_marital().getId());
			statement.setInt(8, user.getNb_enfant());
			statement.setDouble(9, user.getHeure_ouvre());
			statement.setString(10, user.getAdresse1());
			statement.setString(11, user.getAdresse2());
			statement.setInt(12, user.getVille().getId());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				user.setId(resultat);
			}
			else 
				resultat = -1;

		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return resultat;
	}

	// read all
	public List<UserBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<UserBeanModele> userListe = new ArrayList<UserBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_role, matricule, mdp, nom, prenom, id_etat_civil, id_statut_marital, nb_enfant, heure_ouvre, adresse1, adresse2, id_ville FROM user;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			RoleDAOModele roleDAOModele = new RoleDAOModele();
            EtatCivilDAOModele etatCivilDAOModele = new EtatCivilDAOModele();
            StatutMaritalDAOModele statutMaritalDAOModele = new StatutMaritalDAOModele();
            VilleDAOModele villeDAOModele = new VilleDAOModele();
            
            
			
			
			while ( rs.next() )
			{
				UserBeanModele user = new UserBeanModele();
				user.setId(rs.getInt("id"));
                user.setRole(roleDAOModele.lire(rs.getInt("id_role")));
                user.setMatricule(rs.getString("matricule"));
                user.setMdp(rs.getString("mdp"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
                user.setEtat_civil(etatCivilDAOModele.lire(rs.getInt("id_etat_civil")));
                user.setStatut_marital(statutMaritalDAOModele.lire(rs.getInt("id_statut_civil")));
                user.setNb_enfant(rs.getInt("nb_enfant"));
                user.setHeure_ouvre(rs.getDouble("heure_ouvre"));
                user.setAdresse1(rs.getString("adresse1"));
                user.setAdresse2(rs.getString("adresse2"));
                user.setVille(villeDAOModele.lire(rs.getInt("id_ville")));
				
				userListe.add(user);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return userListe;
	}
	
	public UserBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		UserBeanModele user = new UserBeanModele();		

		try
		{
			String requete = new String("SELECT id, id_role, matricule, mdp, nom, prenom, id_etat_civil, id_statut_marital, nb_enfant, heure_ouvre, adresse1, adresse2, id_ville FROM user WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			RoleDAOModele roleDAOModele = new RoleDAOModele();
            EtatCivilDAOModele etatCivilDAOModele = new EtatCivilDAOModele();
            StatutMaritalDAOModele statutMaritalDAOModele = new StatutMaritalDAOModele();
            VilleDAOModele villeDAOModele = new VilleDAOModele();
			
			
			while ( rs.next() )
			{
				user.setId(rs.getInt("id"));
                user.setRole(roleDAOModele.lire(rs.getInt("id_role")));
                user.setMatricule(rs.getString("matricule"));
                user.setMdp(rs.getString("mdp"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
                user.setEtat_civil(etatCivilDAOModele.lire(rs.getInt("id_etat_civil")));
                user.setStatut_marital(statutMaritalDAOModele.lire(rs.getInt("id_statut_civil")));
                user.setNb_enfant(rs.getInt("nb_enfant"));
                user.setHeure_ouvre(rs.getDouble("heure_ouvre"));
                user.setAdresse1(rs.getString("adresse1"));
                user.setAdresse2(rs.getString("adresse2"));
                user.setVille(villeDAOModele.lire(rs.getInt("id_ville")));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return user;
	}
}
