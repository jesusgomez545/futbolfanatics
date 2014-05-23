package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class PublicacionHashtag {
	private static final String tabladb = "publicaciones_hashtag";
	private Integer id_pub;
	private String  id_hash;
	
	public PublicacionHashtag(String  h, Integer p) {
		this.id_hash = h;
		this.id_pub = p;
	}
	
	public static ArrayList<PublicacionHashtag> get(String select, String where, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<PublicacionHashtag> reg = new ArrayList<PublicacionHashtag>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ "from "+tabladb+(where.equals("")? "" : " where ")+where,datos);
			while (res.next()) {				
				PublicacionHashtag r = new PublicacionHashtag(res.getString("id_hashtag"),res.getInt("id_pub"));
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
		datos.add(this.id_hash.getClass().toString());
		datos.add(this.id_hash.toString());
		datos.add(this.id_pub.getClass().toString());
		datos.add(this.id_pub.toString());
		return datos;		
	}

	public Integer getId_pub() {
		return id_pub;
	}

	public void setId_pub(Integer id_pub) {
		this.id_pub = id_pub;
	}

	public String getId_hash() {
		return id_hash;
	}

	public void setId_hash(String id_hash) {
		this.id_hash = id_hash;
	}
}
