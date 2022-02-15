
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//dzd
//DAO pour CRUD (create, read, update, delete)
public class EtatCivilDAOModele {
    
	
	public int creer(EtatCivilBeanModele etat_civil)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO etat_civil (nom) VALUES (?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, etat_civil.getNom());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				etat_civil.setId(resultat);
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
	
	
	public List<EtatCivilBeanModele> lisreListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<EtatCivilBeanModele> etat_civilListe = new ArrayList<EtatCivilBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom FROM etat_civil;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			
			
			while ( rs.next() )
			{
				EtatCivilBeanModele etat_civil = new EtatCivilBeanModele();
				etat_civil.setId(rs.getInt("id"));
                etat_civil.setNom(rs.getString("nom"));
				etat_civilListe.add(etat_civil);
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
		return etat_civilListe;
	}
	
	public EtatCivilBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		EtatCivilBeanModele etat_civil = new EtatCivilBeanModele();		

		try
		{
			String requete = new String("SELECT id, nom FROM etat_civil WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			
			while ( rs.next() )
			{
				etat_civil.setId(rs.getInt("id"));
                etat_civil.setNom(rs.getString("nom"));
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
		return etat_civil;
	}  
}
