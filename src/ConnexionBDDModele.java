import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDDModele {

	Connection connexion;

	public ConnexionBDDModele()
	{

		try
		{
			System.out.println("Chargement de pilote JDBC<-->MySQL  ...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("pilote chargé.");

			String utilisateurBDD = "root"; // Utilisateur de la BD
			String motdepasseBDD = ""; // Password de l'utilisateur de la BD
			String nomBDD = "TAI"; // Nom de la BD sur laquelle nous allons accede	
			// pour mysql			
			String urlBDD = "jdbc:mysql://localhost/"+nomBDD; 
			
			// pour mariadb
			//String urlBDD = "jdbc:mysql://localhost:3308/"+nomBDD+"?useSSL=false";          
			
			//String urlBDD = "jdbc:mysql://localhost:8889/"+nomBDD;   // pour mamp


			try
			{
				connexion = DriverManager.getConnection(urlBDD, utilisateurBDD, motdepasseBDD);
				System.out.println("Connexion établie.");
			}

			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}

	public Connection getConnexion()
	{
		return connexion;
	}	

	public void fermerConnexion()
	{
		try
		{
			connexion.close(); 

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}