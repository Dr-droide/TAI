
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class PaysDAOModele {
        
	
	public int creer(PaysBeanModele pays)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO pays (nom, acronyme) VALUES (?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(2, pays.getNom());
            statement.setString(3, pays.getAcronyme());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				pays.setId(resultat);
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
	
	
	public List<PaysBeanModele> lisreListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<PaysBeanModele> paysListe = new ArrayList<PaysBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, acronyme FROM pays;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			
			
			while ( rs.next() )
			{
				PaysBeanModele pays = new PaysBeanModele();
				pays.setId(rs.getInt("id"));
                pays.setNom(rs.getString("nom"));
				paysListe.add(pays);
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
		return paysListe;
	}
	
	public PaysBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		PaysBeanModele pays = new PaysBeanModele();		

		try
		{
			String requete = new String("SELECT id, nom, acronyme FROM pays WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			
			while ( rs.next() )
			{
				pays.setId(rs.getInt("id"));
                pays.setNom(rs.getString("nom"));
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
		return pays;
	}
}
