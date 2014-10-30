package controladores;

import static constantes.Constantes.ASSETS_PATH;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ManejadorArchivos {
	
	public static boolean guardarArchivos(HttpServletRequest request, String filelocation, String sublocation) throws IOException, IllegalStateException, ServletException
	{
		
		String usuario = String.valueOf(request.getSession().getAttribute("sesion"));
		String appPath = request.getServletContext().getRealPath("");
		
        String savePath = appPath + File.separator + ASSETS_PATH;         
        File fileSaveDir = new File(savePath);  
        File userDir = new File(savePath+ File.separator + usuario);
        
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        savePath = savePath+ File.separator + usuario;
        if (!userDir.exists()) {
            userDir.mkdir();
            
        }       
        
        if(filelocation.equals("profile"))
        {
        	savePath+=File.separator+"profile";
        	
        	File fileSaveDirProfile = new File(savePath);
        	if (fileSaveDirProfile.exists()) {
        		delete(fileSaveDirProfile);
        	}		
        	fileSaveDirProfile.mkdir();
        	
        }else if(filelocation.equals("pub"))
        {
        	savePath+=File.separator+"pub";
        	
        	File fileSaveDirPublications = new File(savePath);
        	if (!fileSaveDirPublications.exists()) {
                fileSaveDirPublications.mkdir();
         	}
        	
		}else if(filelocation.equals("ev")){
			
			savePath+=File.separator+"ev";
			File fileSaveDirEvents = new File(savePath);
        	if (!fileSaveDirEvents.exists()) {
                fileSaveDirEvents.mkdir();
         	} 
		}
        
    	if(sublocation != null)
    	{
    		savePath += File.separator + sublocation;
    		File sublocationDir = new File(savePath);
        	if (!sublocationDir.exists()) {
                sublocationDir.mkdir();
         	}
    	}
        
        for (Part part : request.getParts()) {
        	String fileName = getFileName(part);
        	if(fileName!=null)
        		part.write(savePath + File.separator + fileName);
        }

		return true;		
	}
	
    public static String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    public static void delete(File file)  	throws IOException{
        	if(file.isDirectory()){
        		if(file.list().length==0){
        		   file.delete();
        		}else{
            	   String files[] = file.list();
            	   for (String temp : files) {
            	      File fileDelete = new File(file, temp);
            	     delete(fileDelete);
            	   }
            	   if(file.list().length==0){
               	     file.delete();
            	   }
        		}
        	}else{
        		file.delete();
        	}
        }
}
