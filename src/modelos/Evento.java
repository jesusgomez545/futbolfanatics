package modelos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Evento extends Contenido{
	 private static final String tabladb = "eventos";
	 private Date fechaEvento;
	 private Time horaInicio;
	 private Time horaFin;
	 
	public Evento()
	{
		this.titulo = null;
		this.mensaje = null;
		this.tieneImagen = null;
		this.nombreUsuario = null;
		this.fechaEvento = null;
		this.horaInicio = null;
		this.horaFin = null;		
	}
	 
	public Evento(String titulo, String mensaje, Boolean tieneImagen, String usuario, Date fechaEvento, Time horaInicio, Time horaFin)
	{
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.tieneImagen = tieneImagen;
		this.nombreUsuario = usuario;
		this.fechaEvento = fechaEvento;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public static ArrayList<Evento> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion(); 
		ArrayList<Evento> reg = new ArrayList<Evento>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? " " : complex),datos);
			while (res.next()) {				
                Evento r = new Evento();
                try{r.setTitulo(res.getString("titulo"));}catch(SQLException e){}
                try{r.setMensaje(res.getString("mensaje"));}catch(SQLException e){}
                try{r.setTieneImagen(res.getBoolean("tiene_imagen"));}catch(SQLException e){}
                try{r.setNombreUsuario(res.getString("nombre_usuario"));}catch(SQLException e){}
                try{r.setFechaEvento(res.getDate("fecha_evento"));}catch(SQLException e){}
                try{r.setHoraInicio(res.getTime("hora_inicio"));}catch(SQLException e){}
                try{r.setHoraFin(res.getTime("hora_fin"));}catch(SQLException e){}
                		
                r.setId(res.getInt("id"));
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
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" (titulo,mensaje,tiene_imagen,nombre_usuario,fecha_evento,hora_inicio,hora_fin) values(?,?,?,?,?,?,?)",this.toArray());
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
		datos.add(this.titulo.getClass().toString());
		datos.add(this.titulo);
		datos.add(this.mensaje.getClass().toString());
		datos.add(this.mensaje);
		datos.add(this.tieneImagen.getClass().toString());
		datos.add(this.tieneImagen.toString());
		datos.add(this.nombreUsuario.getClass().toString());
		datos.add(this.nombreUsuario);
		datos.add(this.fechaEvento.getClass().toString());
		datos.add(this.fechaEvento.toString());
		datos.add(this.horaInicio.getClass().toString());
		datos.add(this.horaInicio.toString());
		datos.add(this.horaFin.getClass().toString());
		datos.add(this.horaFin.toString());
		return datos;		
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}	 
}