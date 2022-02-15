
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class VilleDAOModele {
        
	
	public int creer(VilleBeanModele ville)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO ville (nom, bp, id_pays) VALUES (?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, ville.getNom());
            statement.setString(2, ville.getBp());
            statement.setInt(3, ville.getPays().getId());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				ville.setId(resultat);
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
	
	
	public List<VilleBeanModele> lisreListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<VilleBeanModele> villeListe = new ArrayList<VilleBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, bp, id_pays FROM ville;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			PaysDAOModele paysDAOModele = new PaysDAOModele();
			
			while ( rs.next() )
			{
				VilleBeanModele ville = new VilleBeanModele();
				ville.setId(rs.getInt("id"));
                ville.setNom(rs.getString("nom"));
                ville.setBp(rs.getString("bp"));
                ville.setPays(paysDAOModele.lire(rs.getInt("pays")));
				villeListe.add(ville);
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
		return villeListe;
	}
	
	public VilleBeanModele lire (int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		VilleBeanModele ville = new VilleBeanModele();		

		try
		{
			String requete = new String("SELECT id, nom, bp, id_pays FROM ville WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			PaysDAOModele paysDAOModele = new PaysDAOModele();
			
			
			while ( rs.next() )
			{
				ville.setId(rs.getInt("id"));
                ville.setNom(rs.getString("nom"));
                ville.setBp(rs.getString("bp"));
                ville.setPays(paysDAOModele.lire(rs.getInt("pays")));
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
		return ville;
	}
}
