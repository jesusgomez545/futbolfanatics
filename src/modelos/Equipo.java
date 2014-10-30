package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Equipo{
	private static final String tabladb = "equipo";
	private Integer id;
	private String nombre;
	private String pais;
	
	public Equipo()
	{
		this.nombre = null;
		this.id= null;
		this.pais = null;
	}
	
	public Equipo (String nombre, String pais)
	{
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public static ArrayList<Equipo> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<Equipo> reg = new ArrayList<Equipo>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? "" : complex),datos);
			while (res.next()) {				
                Equipo r = new Equipo();
          		try{r.setNombre(res.getString("nombre"));}catch(SQLException e){}
           		try{r.setNombre(res.getString("pais"));}catch(SQLException e){}
           		try{r.setId(res.getInt("id"));}catch(SQLException e){}
                reg.add(r);                
            }		
			Conexion.cerrarConexion(con);
			return reg;
		}else{
			return null;
		}	
	}
	
	public boolean save() throws ClassNotFoundException, SQLException{
		Connection con = Conexion.abrirConexion();
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" (nombre,pais) values(?,?)",this.toArray());
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
		datos.add(this.pais.getClass().toString());
		datos.add(this.pais.toString());
		return datos;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
