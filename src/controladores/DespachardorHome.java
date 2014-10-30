package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class DespachardorHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DespachardorHome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if (request.getSession().getAttribute("sesion")==null){
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{		
	}

}
