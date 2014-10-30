package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class RegistradoEquipo {
	private static final String tabladb = "registrado_equipo";
	private String id_registrado;
	private Integer id_equipo;
	
	public RegistradoEquipo() {
		this.id_registrado = null;
		this.id_equipo = null;
	}
	
	public RegistradoEquipo(String r, Integer e) {
		this.id_registrado = r;
		this.id_equipo = e;
	}
	
	public static ArrayList<RegistradoEquipo> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<RegistradoEquipo> reg = new ArrayList<RegistradoEquipo>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? "" : complex),datos);
			while (res.next()) {				
				RegistradoEquipo r = new RegistradoEquipo();
				try{r.setId_registrado(res.getString("id_registrado"));}catch(SQLException e){}
				try{r.setId_equipo(res.getInt("id_equipo"));}catch(SQLException e){}	
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
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" values(?,?)",this.toArray());
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
		datos.add(this.id_registrado.getClass().toString());
		datos.add(this.id_registrado.toString());
		datos.add(this.id_equipo.getClass().toString());
		datos.add(this.id_equipo.toString());
		return datos;		
	}

	public String getId_registrado() {
		return id_registrado;
	}

	public void setId_registrado(String id_registrado) {
		this.id_registrado = id_registrado;
	}

	public Integer getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(Integer id_equipo) {
		this.id_equipo = id_equipo;
	}


}
