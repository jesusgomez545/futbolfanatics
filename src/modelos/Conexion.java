package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constantes.Constantes.DBNAME;
import static constantes.Constantes.DBUSER;
import static constantes.Constantes.DBPASSWD;
import static constantes.Constantes.DBPORT;
import static constantes.Constantes.DBHOST;

public class Conexion {	
	
	public static  Connection abrirConexion() throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://"+DBHOST+":"+DBPORT+"/"+DBNAME, DBUSER, DBPASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	
	public static boolean cerrarConexion(Connection con) {
		try {
			con.close();
			return con.equals(null);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
