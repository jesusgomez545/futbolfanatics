package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Publicacion;

@WebServlet("/editar")
public class EditarPublicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarPublicacion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("sesion")==null){
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else
			this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		if (request.getSession().getAttribute("sesion")==null){
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		try
		{
			response.setContentType("application/json"); 
			response.setCharacterEncoding("utf-8");
			
			if(request.getParameterMap().containsKey("id") && request.getParameterMap().containsKey("mensaje"))
			{	
				ArrayList<String> datos = new ArrayList<String>(); 
				datos.add(String.class.toString());
				datos.add(request.getParameter("mensaje"));
				datos.add(Integer.class.toString());
				datos.add(request.getParameter("id"));
				Publicacion.update("mensaje = ?", "id = ?", datos);
				String ok = "{\"status\":\"OK\"}";
				response.getWriter().write(ok);
				response.setStatus(200);
			}else
			{
				response.getWriter().write("{'status':'no parameter [id] and [mensaje] on request body were found'}");
				response.setStatus(500);
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	
	}

}
