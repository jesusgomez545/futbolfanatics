package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Registrado;

@WebServlet("/entrar")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IniciarSesion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try
		{
			response.setContentType("application/json"); 
			response.setCharacterEncoding("utf-8");
			
			if(request.getParameterMap().containsKey("usuario") && request.getParameterMap().containsKey("clave"))
			{
				ArrayList<String> datos = new ArrayList<String>(); 
				datos.add(String.class.toString());
				datos.add(request.getParameter("usuario"));
				datos.add(String.class.toString());
				datos.add(request.getParameter("clave"));
				ArrayList<Registrado> p1  = Registrado.get("*", "where nombre_usuario = ? and clave = ?::text", datos);
				
				if(p1.size()>0)
				{
					request.getSession().setAttribute("sesion", request.getParameter("usuario"));
					request.getSession().setAttribute("imagen", p1.get(0).getImagenPerfil());
					response.setStatus(200);
					response.getWriter().write("{\"status\":200}");
				}else
				{
					response.setStatus(500);
				}
			}else
			{
				response.getWriter().write("no parameter [usuario, clave] on request body were found");
				response.setStatus(500);
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
		
	}

}
