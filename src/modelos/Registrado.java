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
	
	public Registrado(String nombreUsuario, String nombre, String apellido, int edad, String correo, String clave)
	{
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.clave = clave;
	}

	public static ArrayList<Registrado> get(String select, String where, ArrayList<String> datos) throws ClassNotFoundException, NumberFormatException, SQLException
	{
		Connection con = Conexion.abrirConexion();
		ArrayList<Registrado> reg = new ArrayList<Registrado>();
		if(con != null)
		{
			ResultSet res = ConsultaSegura.hacerConsulta(con,"select "+select+ "from "+tabladb+(where.equals("")? "" : " where ")+where,datos);
			while (res.next()) {				
                Registrado r = new Registrado(res.getString("nombre_usuario"),res.getString("nombre"),res.getString("apellido"),Integer.parseInt(res.getString("edad")),res.getString("correo"),res.getString("clave"));
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
		ConsultaSegura.hacerConsulta(con,"insert into "+tabladb+" values(?,?,?,?,?,?)",this.toArray());
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
}
