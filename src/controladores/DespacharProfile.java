package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Equipo;
import modelos.Registrado;

@WebServlet("/profile")
public class DespacharProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DespacharProfile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		if (request.getSession().getAttribute("sesion")==null){
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		try {
			ArrayList<String> datos = new ArrayList<String>(); 
			datos.add(String.class.toString());
			datos.add(String.valueOf(request.getSession().getAttribute("sesion")));
			
			ArrayList<Registrado> p  = Registrado.get("*", "where nombre_usuario = ?", datos);			
			ArrayList<Equipo> e = Equipo.get("distinct nombre", "", null);
			ArrayList<Equipo> f = Equipo.get("nombre", "where id in (select id_equipo from registrado_equipo where id_registrado = ?)", datos);
			
			request.setAttribute("perfil", p.get(0));
			request.setAttribute("equipos", e);
			request.setAttribute("favoritos", f);
			
			this.getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
