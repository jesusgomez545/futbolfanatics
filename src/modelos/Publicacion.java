package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Publicacion extends Contenido {
	
	private static final String tabladb = "publicaciones";
	private Timestamp fechaPublicacion;	
	
	public Publicacion()
	{
		this.titulo = null;
		this.mensaje = null;
		this.tieneImagen = null;
		this.nombreUsuario = null;
	}
	
	public Publicacion(String titulo, String mensaje, Boolean tieneImagen, String usuario)
	{
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.tieneImagen = tieneImagen;
		this.nombreUsuario = usuario;
	}
	
	public Timestamp getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Timestamp fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public static ArrayList<Publicacion> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<Publicacion> reg = new ArrayList<Publicacion>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? " " : complex),datos);
			while (res.next()) {				
                Publicacion r = new Publicacion();
                try{r.setTitulo(res.getString("titulo"));}catch(SQLException e){}
                try{r.setMensaje(res.getString("mensaje"));}catch(SQLException e){}
                try{r.setTieneImagen(res.getBoolean("tiene_imagen"));}catch(SQLException e){}
                try{r.setNombreUsuario(res.getString("nombre_usuario"));}catch(SQLException e){}
                try{r.setId(res.getInt("id"));}catch(SQLException e){}
                try{r.setFechaPublicacion(res.getTimestamp("fecha_pub"));}catch(SQLException e){}
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
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" (titulo,mensaje,tiene_imagen,nombre_usuario) values(?,?,?,?)",this.toArray());
		Conexion.cerrarConexion(con);
		return true;	
	}
	
	public String toJson()
	{
			Gson gson = new Gson();
			return gson.toJson(this);
	}
	
	public ArrayList<String> toArray()
	{
		ArrayList<String> datos = new ArrayList<String>();
		datos.add(this.titulo.getClass().toString());
		datos.add(this.titulo);
		datos.add(this.mensaje.getClass().toString());
		datos.add(this.mensaje);
		datos.add(this.tieneImagen.getClass().toString());
		datos.add(this.tieneImagen.toString());
		datos.add(this.nombreUsuario.getClass().toString());
		datos.add(this.nombreUsuario);
		return datos;		
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
}