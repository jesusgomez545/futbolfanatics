package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class EventoHashtag {
	private static final String tabladb = "evento_hashtag";
	private String id_hashtag;
	private Integer id_event;
	
	public EventoHashtag(String h, Integer e)
	{
		this.id_hashtag = h;
		this.id_event = e;
	}

	public static ArrayList<EventoHashtag> get(String select, String where, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<EventoHashtag> reg = new ArrayList<EventoHashtag>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ "from "+tabladb+(where.equals("")? "" : " where ")+where,datos);
			while (res.next()) {				
				EventoHashtag r = new EventoHashtag(res.getString("id_hashtag"),res.getInt("id_event"));
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
		datos.add(this.id_hashtag.getClass().toString());
		datos.add(this.id_hashtag.toString());
		datos.add(this.id_event.getClass().toString());
		datos.add(this.id_event.toString());
		return datos;		
	}

	public String getId_hashtag() {
		return id_hashtag;
	}

	public void setId_hashtag(String id_hashtag) {
		this.id_hashtag = id_hashtag;
	}

	public Integer getId_event() {
		return id_event;
	}

	public void setId_event(Integer id_event) {
		this.id_event = id_event;
	}

}
