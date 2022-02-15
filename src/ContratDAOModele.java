
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//dzd
//DAO pour CRUD (create, read, update, delete)
public class ContratDAOModele {
 
	// CRUD: create(obj)
	public int creer(ContratBeanModele contrat)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO contrat (id_user, nb_heure, salaire_horaire, id_fonction, id_categorie, id_echelon, id_departement, date_embauche) VALUES (?,?,?,?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, contrat.getUser().getId());
			statement.setDouble(2, contrat.getNb_heure());
			statement.setDouble(3, contrat.getSalaire_horaire());
			statement.setInt(4, contrat.getFonction().getId());
			statement.setInt(5, contrat.getCategorie().getId());
			statement.setInt(6, contrat.getEchelon().getId());
			statement.setInt(7, contrat.getDepartement().getId());			
			statement.setString(8, contrat.getDate_embauche());
			
			


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				contrat.setId(resultat);
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
	public List<ContratBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<ContratBeanModele> contratListe = new ArrayList<ContratBeanModele>();		

		try
		{
			String requete = new String("SELECT id, id_user, nb_heure, salaire_horaire, id_fonction, id_categorie, id_echelon, id_departement, date_embauche FROM contrat;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			UserDAOModele userDAOModele = new UserDAOModele();
			FonctionDAOModele fonctionDAOModele = new FonctionDAOModele();
			CategorieDAOModele categorieDAOModele = new CategorieDAOModele();
			EchelonDAOModele echelonDAOModele = new EchelonDAOModele();
			DepartementDAOModele departementDAOModele = new DepartementDAOModele();
          
            
            
			
			
			while ( rs.next() )
			{
				ContratBeanModele contrat = new ContratBeanModele();
				contrat.setId(rs.getInt("id"));
                contrat.setUser(userDAOModele.lire(rs.getInt("id_user")));
                contrat.setNb_heure(rs.getDouble("nb_heure"));
                contrat.setSalaire_horaire(rs.getDouble("salaire_horaire"));
				contrat.setFonction(fonctionDAOModele.lire(rs.getInt("id_fonction")));
                contrat.setCategorie(categorieDAOModele.lire(rs.getInt("id_categorie")));
                contrat.setEchelon(echelonDAOModele.lire(rs.getInt("id_echelon")));  // pk ???
                contrat.setDepartement(departementDAOModele.lire(rs.getInt("id_departement")));
                contrat.setDate_embauche(rs.getString("date_embauche"));
                
               
				
				contratListe.add(contrat);
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
		return contratListe;
	}
	
	public ContratBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ContratBeanModele contrat = new ContratBeanModele();		

		try
		{
			String requete = new String("SELECT id, id_user, nb_heure, salaire_horaire, id_fonction, id_categorie, id_echelon, id_departement, date_embauche FROM contrat WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			UserDAOModele userDAOModele = new UserDAOModele();
			FonctionDAOModele fonctionDAOModele = new FonctionDAOModele();
			CategorieDAOModele categorieDAOModele = new CategorieDAOModele();
			EchelonDAOModele echelonrDAOModele = new EchelonDAOModele();
			DepartementDAOModele departementDAOModele = new DepartementDAOModele();
			
			
			while ( rs.next() )
			{
				contrat.setId(rs.getInt("id"));
                contrat.setUser(userDAOModele.lire(rs.getInt("id_user")));
                contrat.setNb_heure(rs.getDouble("nb_heure"));
                contrat.setSalaire_horaire(rs.getDouble("salaire_horaire"));
				contrat.setFonction(fonctionDAOModele.lire(rs.getInt("id_fonction")));
                contrat.setCategorie(categorieDAOModele.lire(rs.getInt("id_categorie")));
                contrat.setEchelon(echelonDAOModele.lire(rs.getInt("id_echelon")));  // pk ???
                contrat.setDepartement(departementDAOModele.lire(rs.getInt("id_departement")));
                contrat.setDate_embauche(rs.getString("date_embauche"));
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
		return contrat;
	}
}