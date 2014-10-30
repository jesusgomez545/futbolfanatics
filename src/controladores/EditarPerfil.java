package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelos.Equipo;
import modelos.Registrado;
import modelos.RegistradoEquipo;

@WebServlet("/editprofile")
@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*10, maxRequestSize=1024*1024*5*5)
public class EditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarPerfil() {
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
		
		try {
			if(request.getParameterMap().containsKey("team0") && request.getParameterMap().containsKey("email") )
			{
				String n = null;
				String user = String.valueOf(request.getSession().getAttribute("sesion"));
				ArrayList<String> datos = new ArrayList<String>(); 
				datos.add(String.class.toString());
				datos.add(request.getParameter("email"));
				
				for(Part p :  request.getParts())
				{
					n = ManejadorArchivos.getFileName(p); 
					if(n != null)
					{
						datos.add(String.class.toString());
						datos.add(n);
						request.getSession().setAttribute("imagen", n);
						break;
					}
				}
				datos.add(String.class.toString());
				datos.add(user);	
				
				Integer i =0;
				String listA = "where nombre in (";
				ArrayList<String> datos1 = new ArrayList<String>();
				
				while(request.getParameterMap().containsKey("team"+i.toString()))
				{
					datos1.add(String.class.toString());
					datos1.add(request.getParameter("team"+i.toString()));
					listA += "?" ;
					
					if(request.getParameterMap().containsKey("team"+String.valueOf((i+1))))
					{
						listA+=",";
					}
					++i;
				}
				listA += ")";
				ArrayList<Equipo> e = Equipo.get("id", listA, datos1);	
				
				while(e.size()!=0 )
				{
					try{
						(new RegistradoEquipo(user,e.get(0).getId())).save();
					}catch(Exception unique_key){}
					e.remove(0);
				}
				
				Registrado.update("correo = ?, imagen_perfil = ?","nombre_usuario = ?", datos);
				ManejadorArchivos.guardarArchivos(request,"profile", "");
				this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			}			

		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
