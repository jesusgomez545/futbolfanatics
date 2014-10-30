package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Registrado {
	
	private static final String tabladb = "registrado";
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String correo;
	private String clave;
	private String imagenPerfil; 
	
	public Registrado()
	{
		this.nombreUsuario = null;
		this.nombre = null;
		this.apellido = null;
		this.edad = null;
		this.correo = null;
		this.clave = null;
		this.imagenPerfil = null;
	}

	
	public Registrado(String nombreUsuario, String nombre, String apellido, int edad, String correo, String clave,String imagenPerfil)
	{
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.clave = clave;
		this.imagenPerfil =  imagenPerfil;
	}

	public static ArrayList<Registrado> get(String select, String complex, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<Registrado> reg = new ArrayList<Registrado>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ " from "+tabladb+" "+(complex.equals("")? "" : complex),datos);
			while (res.next()) {				
                Registrado r = new Registrado();
                try{r.setNombreUsuario(res.getString("nombre_usuario"));}catch(SQLException e){}
                try{r.setNombre(res.getString("nombre"));}catch(SQLException e){}
                try{r.setApellido(res.getString("apellido"));}catch(SQLException e){}
                try{r.setEdad(Integer.parseInt(res.getString("edad")));}catch(SQLException e){}
                try{r.setCorreo(res.getString("correo"));}catch(SQLException e){}
                try{r.setClave(res.getString("clave")); }catch(SQLException e){}
                try{r.setImagenPerfil(res.getString("imagen_perfil"));}catch(SQLException e){}
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
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" values(?,?,?,?,?,?,?)",this.toArray());
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
		datos.add(this.nombreUsuario.getClass().toString());
		datos.add(this.nombreUsuario);
		datos.add(this.nombre.getClass().toString());
		datos.add(this.nombre);
		datos.add(this.apellido.getClass().toString());
		datos.add(this.apellido);
		datos.add(this.edad.getClass().toString());
		datos.add(this.edad.toString());
		datos.add(this.correo.getClass().toString());
		datos.add(this.correo);
		datos.add(this.clave.getClass().toString());
		datos.add(this.clave);
		datos.add(this.imagenPerfil.getClass().toString());
		datos.add(this.imagenPerfil);
		return datos;		
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}
}
