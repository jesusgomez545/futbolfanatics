package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Publicacion;

@WebServlet("/mostrar")
public class MostrarPublicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarPublicacion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try
		{
			response.setContentType("application/json"); 
			response.setCharacterEncoding("utf-8");
			
			if(request.getParameterMap().containsKey("id"))
			{
				ArrayList<String> datos = new ArrayList<String>(); 
				datos.add(Integer.class.toString());
				datos.add(request.getParameter("id"));
				ArrayList<Publicacion> p  = Publicacion.get("*", "where id = ?", datos);
				String all="";
				
				if(p.size()>0){
					all+=p.get(0).toJson();
				}else{
					response.getWriter().write("no publication found for id");
					response.setStatus(500);
					return;
				}
				
				response.getWriter().write(all);
				response.setStatus(200);
			}else
			{
				response.getWriter().write("no parameter [id] on request body were found");
				response.setStatus(500);
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{}

}
