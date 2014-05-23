package modelos;

public class Contenido {
	protected Integer id;
	protected String titulo;
	protected String mensaje;
	protected Boolean tieneImagen;
	protected String nombreUsuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getTieneImagen() {
		return tieneImagen;
	}
	public void setTieneImagen(Boolean tieneImagen) {
		this.tieneImagen = tieneImagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
