package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Publicacion;

/**
 * Servlet implementation class AgregarPublicacion
 */
@WebServlet("/add")
public class AgregarPublicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarPublicacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("sesion")==null){
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		try
		{
			response.setContentType("application/json"); 
			response.setCharacterEncoding("utf-8");
			
			if(request.getParameterMap().containsKey("content") && request.getParameterMap().containsKey("title"))
			{	
				(new Publicacion(request.getParameter("title"),request.getParameter("content"),false, String.valueOf(request.getSession().getAttribute("sesion")))).save();
				String ok = "{\"status\":\"OK\"}";
				response.getWriter().write(ok);
				response.setStatus(200);
			}else
			{
				response.getWriter().write("{'status':'no parameter [content] and [title] on request body were found'}");
				response.setStatus(500);
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	}

}
