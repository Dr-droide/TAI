
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class FichePaieDAOModele {
 
	// CRUD: create(obj)
	public int creer(FichePaieBeanModele fichePaie)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO fichePaie (id_user, id_mois, annee, id_contrat, heure_ouvre) VALUES (?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, fichePaie.getUser().getId());
			statement.setInt(2, fichePaie.getMois().getId());
			statement.setInt(3, fichePaie.getAnnee()); 
			statement.setInt(4, fichePaie.getContrat().getId());			
			statement.setDouble(5, fichePaie.getHeure_ouvre());
			


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				fichePaie.setId(resultat);
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
	public List<FichePaieBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<FichePaieBeanModele> fichePaieListe = new ArrayList<FichePaieBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_user, id_mois, annee, id_contrat, heure_ouvre FROM fichePaie;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			UserDAOModele userDAOModele = new UserDAOModele();
			MoisDAOModele moisDAOModele = new MoisDAOModele();
			ContratDAOModele contratDAOModele = new ContratDAOModele();
            
            
			
			
			while ( rs.next() )
			{
				FichePaieBeanModele fichePaie = new FichePaieBeanModele();
				fichePaie.setId(rs.getInt("id"));				
                fichePaie.setUser(userDAOModele.lire(rs.getInt("id_user")));
                fichePaie.setMois(moisDAOModele.lire(rs.getInt("id_mois")));
                fichePaie.setAnnee(rs.getInt("annee"));
                fichePaie.setContrat(contratDAOModele.lire(rs.getInt("id_contrat")));
                fichePaie.setHeure_ouvre(rs.getDouble("heure_ouvre"));
   
                
				fichePaieListe.add(fichePaie);
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
		return fichePaieListe;
	}
	
	public FichePaieBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		FichePaieBeanModele fichePaie = new FichePaieBeanModele();		

		try
		{
			String requete = new String("SELECT id, id_user, id_mois, annee, id_contrat, heure_ouvre FROM fichePaie WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			UserDAOModele userDAOModele = new UserDAOModele();
			MoisDAOModele moisDAOModele = new MoisDAOModele();
			ContratDAOModele contratDAOModele = new ContratDAOModele();
			
			
			while ( rs.next() )
			{
				fichePaie.setId(rs.getInt("id"));
                fichePaie.setUser(userDAOModele.lire(rs.getInt("id_user")));
                fichePaie.setMois(moisDAOModele.lire(rs.getInt("id_mois")));
                fichePaie.setAnnee(rs.getInt("annee"));
                fichePaie.setContrat(contratDAOModele.lire(rs.getInt("id_contrat")));
                fichePaie.setHeure_ouvre(rs.getDouble("heure_ouvre"));
                
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
		return fichePaie;
	}
	
}