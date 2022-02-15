
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class StatutMaritalDAOModele {
	//dzd       
	
	public int creer(StatutMaritalBeanModele statut_marital)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO statut_marital (nom) VALUES (?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, statut_marital.getNom());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				statut_marital.setId(resultat);
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
	
	
	public List<StatutMaritalBeanModele> lisreListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<StatutMaritalBeanModele> statut_maritalListe = new ArrayList<StatutMaritalBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom FROM statut_marital;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			
			
			while ( rs.next() )
			{
				StatutMaritalBeanModele statut_marital = new StatutMaritalBeanModele();
				statut_marital.setId(rs.getInt("id"));
                statut_marital.setNom(rs.getString("nom"));
				statut_maritalListe.add(statut_marital);
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
		return statut_maritalListe;
	}
	
	public StatutMaritalBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		StatutMaritalBeanModele statut_marital = new StatutMaritalBeanModele();		

		try
		{
			String requete = new String("SELECT id, nom FROM statut_marital WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			
			while ( rs.next() )
			{
				statut_marital.setId(rs.getInt("id"));
                statut_marital.setNom(rs.getString("nom"));
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
		return statut_marital;
	}
}
