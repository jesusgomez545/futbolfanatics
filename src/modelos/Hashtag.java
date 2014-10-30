package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Hashtag {
	private static final String tabladb = "hashtag";
	private String nombre;
	private Integer id;
	
	public Hashtag()
	{
		this.nombre = null;
	}
	
	public Hashtag(String nombre) {
		this.nombre = nombre;
	}
	
	public static ArrayList<Hashtag> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<Hashtag> reg = new ArrayList<Hashtag>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? "" : complex),datos);
			while (res.next()) {				
                Hashtag r = new Hashtag();
                try{r.setNombre(res.getString("nombre"));}catch(SQLException e){}
                try{r.setId(res.getInt("id"));}catch(SQLException e){}
                reg.add(r);                
            }		
			Conexion.cerrarConexion(con);
			return reg;
		}else{
			return null;
		}	
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean save() throws ClassNotFoundException, SQLException{
		Connection con = Conexion.abrirConexion();
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" (nombre) values(?)",this.toArray());
		Conexion.cerrarConexion(con);
		return true;	
	}
	
	public static boolean update(String set, String where, ArrayList<String> datos) throws ClassNotFoundException
	{
		Connection con = Conexion.abrirConexion();
		if(con != null)
		{
			ConsultaSegura.hacerConsulta(con,"update "+tabladb+" set "+set+" where "+where,datos);
			Conexion.cerrarConexion(con);
			return true;			
		}else{
			return false;
		}	
	}
	
	public static boolean delete(String using, String where, ArrayList<String> datos) throws ClassNotFoundException
	{
		Connection con = Conexion.abrirConexion();
		if(con != null)
		{
			ConsultaSegura.hacerConsulta(con,"delete from "+tabladb+" "+using+" where "+where,datos);
			Conexion.cerrarConexion(con);
			return true;			
		}else{
			return false;
		}		
	}
	
	public String toJson()
	{
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public ArrayList<String> toArray()
	{
		ArrayList<String> datos = new ArrayList<String>();
		datos.add(this.nombre.getClass().toString());
		datos.add(this.nombre.toString());
		return datos;		
	}
}
