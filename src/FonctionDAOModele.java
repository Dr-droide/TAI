
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//dzd
//DAO pour CRUD (create, read, update, delete)
public class FonctionDAOModele {
        
	
	public int creer(FonctionBeanModele fonction)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO fonction (nom) VALUES (?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(2, fonction.getNom());
            


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				fonction.setId(resultat);
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
	
	
	public List<FonctionBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<FonctionBeanModele> fonctionListe = new ArrayList<FonctionBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom FROM fonction;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			
			
			while ( rs.next() )
			{
				FonctionBeanModele fonction = new FonctionBeanModele();
				fonction.setId(rs.getInt("id"));
                fonction.setNom(rs.getString("nom"));
                fonctionListe.add(fonction);
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
		return fonctionListe;
	}
	
	public FonctionBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		FonctionBeanModele fonction = new FonctionBeanModele();		

		try
		{
			String requete = new String("SELECT id, nom FROM fonction WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			
			while ( rs.next() )
			{
				fonction.setId(rs.getInt("id"));
                fonction.setNom(rs.getString("nom"));
                
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
		return fonction;
	}
}

