
import java.sql.Connection; //zdd
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class AffectationDAOModele {
        
	
	public int creer(AffectationBeanModele affectation)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO affectation (id_user, nom, description, date_debut, date_fin, emargement) VALUES (?,?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);


			statement.setInt(1, affectation.getUser().getId());
			statement.setString(2, affectation.getNom());
			statement.setString(3, affectation.getDescription());		
			statement.setString(4, affectation.getDate_debut());
			statement.setString(5, affectation.getDate_fin());
			statement.setBoolean(6, affectation.isEmargement());  
			
			

            


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				affectation.setId(resultat);
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
	
	
	public List<AffectationBeanModele> lireListeUser(int id_user){
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<AffectationBeanModele> affectationListe = new ArrayList<AffectationBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_user, nom, description, date_debut, date_fin, emargement nom FROM affectation WHERE id_user=?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id_user);
			ResultSet rs = statement.executeQuery(requete);
			UserDAOModele userDAOModele = new UserDAOModele();
			
			
			while ( rs.next() )
			{
				AffectationBeanModele affectation = new AffectationBeanModele();
				affectation.setId(rs.getInt("id")); 
                affectation.setUser(userDAOModele.lire(rs.getInt("id_user")));
                affectation.setNom(rs.getString("nom"));
                affectation.setDescription(rs.getString("description"));
                affectation.setDate_debut(rs.getString("date_debut"));
                affectation.setDate_fin(rs.getString("date_fin"));
                         
                
                affectationListe.add(affectation);
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
		return affectationListe;
	}
	
	public List<AffectationBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<AffectationBeanModele> affectationListe = new ArrayList<AffectationBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_user, nom, description, date_debut, date_fin, emargement nom FROM affectation;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			UserDAOModele userDAOModele = new UserDAOModele();
			
			
			while ( rs.next() )
			{
				AffectationBeanModele affectation = new AffectationBeanModele();
				affectation.setId(rs.getInt("id")); 
                affectation.setUser(userDAOModele.lire(rs.getInt("id_user")));
                affectation.setNom(rs.getString("nom"));
                affectation.setDescription(rs.getString("description"));
                affectation.setDate_debut(rs.getString("date_debut"));
                affectation.setDate_fin(rs.getString("date_fin"));
                         
                
                affectationListe.add(affectation);
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
		return affectationListe;
	}
	
	public AffectationBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		AffectationBeanModele affectation = new AffectationBeanModele();		

		try
		{
			String requete = new String("SELECT id, id_user, nom, description, date_debut, date_fin, emargement nom FROM affectation;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			UserDAOModele userDAOModele = new UserDAOModele();
			
			
			while ( rs.next() )
			{
				affectation.setId(rs.getInt("id")); 
                affectation.setUser(userDAOModele.lire(rs.getInt("id_user")));
                affectation.setNom(rs.getString("nom"));
                affectation.setDescription(rs.getString("description"));
                affectation.setDate_debut(rs.getString("date_debut"));
                affectation.setDate_fin(rs.getString("date_fin"));
                
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
		return affectation;
	}
}

