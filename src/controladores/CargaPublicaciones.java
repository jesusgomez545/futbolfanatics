package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Publicacion;

@WebServlet("/pubs")
public class CargaPublicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CargaPublicaciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{		
		try
		{
			response.setContentType("application/json"); 
			response.setCharacterEncoding("utf-8");
			
			if(request.getParameterMap().containsKey("p"))
			{
				int pagina = Integer.valueOf(request.getParameter("p"));
				ArrayList<String> datos = new ArrayList<String>(); 
				datos.add(Integer.class.toString());
				datos.add(String.valueOf((pagina*5)));
				ArrayList<Publicacion> p  = Publicacion.get("*", "limit 5 offset ?", datos);
				String all="{}";
				
				if(p.size()>0){
					all = "[";
					int l = p.size();
								
					for(int j=0;j< l-1;++j){
						all+=p.get(j).toJson()+",";
					}
					all+=p.get(l-1).toJson()+"]";
				}
				
				response.getWriter().write(all);
				response.setStatus(200);
			}else
			{
				response.getWriter().write("no parameter [p] on request body were found");
				response.setStatus(500);
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
	}

}
