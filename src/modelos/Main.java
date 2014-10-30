package modelos;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, ClassNotFoundException, SQLException {

		ArrayList<EventoHashtag> r = EventoHashtag.get(" * ", "", null);
		for( int i=0; i<r.size();++i)
			System.out.println(r.get(i).toJson());
		
		System.out.println("==================================");
		
		EventoHashtag m = new EventoHashtag("Brasil2014", 6);
		m.save();
		
		r = EventoHashtag.get(" * ", "", null);
		for( int i=0; i<r.size();++i)
			System.out.println(r.get(i).toJson());
		
		System.out.println("==================================");
		
		ArrayList<String> datos = new ArrayList<String>(); 
		datos.add(String.class.toString());
		datos.add("jesusgomez545");
		ArrayList<Evento> re = Evento.get(" * ", "where nombre_usuario = ?", datos);
		System.out.println(re.get(0).toJson());
		
		System.out.println("==================================");
		
		Evento.update("titulo = 'China vs Argentina :)'", "id = 7", null);
		
		ArrayList<String> datos3 = new ArrayList<String>(); 
		datos3.add(String.class.toString());
		datos3.add("jhon");		
		ArrayList<Registrado> re1 = Registrado.get(" * ", "where nombre = ?", datos3);
		System.out.println(re1.get(0).toJson());
		System.out.println(re1.get(1).toJson());
		System.out.println(re1.get(2).toJson());
		
		System.out.println("==================================");
		
		Registrado.update("apellido = 'update'", "nombre = 'jhon'", null);
		
		ArrayList<String> datos2 = new ArrayList<String>(); 
		datos2.add(String.class.toString());
		datos2.add("magle13");
		Registrado.delete("", "nombre_usuario = ?", datos2);
		
		Registrado nuevo = new Registrado("yisus565","jhon","gomez",23,"jhon@origin.com","123","");
		nuevo.save();
		
		System.out.println("==================================");
		
		ArrayList<Registrado> r1 = Registrado.get(" * ", "", null);
		for( int i=0; i<r1.size();++i)
			System.out.println(r1.get(i).toJson());
		
		System.out.println("==================================");
		
		ArrayList<String> datos4 = new ArrayList<String>(); 
		datos4.add(Integer.class.toString());
		datos4.add("0");
		ArrayList<Publicacion> p  = Publicacion.get("*", " limit 5 offset ?", datos4);
		for(int j=0;j<p.size();++j)
			System.out.println(p.get(j).toJson());	
		
		System.out.println("==================================");
		
		ArrayList<String> datos6 = new ArrayList<String>(); 
		datos6.add(String.class.toString());
		datos6.add("yisus545");
		datos6.add(String.class.toString());
		datos6.add("jesus$%nacho");
		ArrayList<Registrado> p1  = Registrado.get("*", "where nombre_usuario = ? and clave = ?::text", datos6);
		System.out.println(p1.get(0).toJson());
		
		System.out.println("==================================");
		ArrayList<Equipo> e = Equipo.get("distinct pais", "", null);
		for( int i=0; i<e.size();++i)
			System.out.println(e.get(i).toJson());
		
		System.out.println("==================================");
		ArrayList<String> datos7 = new ArrayList<String>(); 
		datos7.add(String.class.toString());
		datos7.add("yisus545");
		ArrayList<Equipo> fav = Equipo.get("nombre", "where id in (select id_equipo from registrado_equipo where id_registrado = ?)", datos7);
		
		for( int i=0; i<fav.size();++i)
			System.out.println(fav.get(i).toJson());
		
		
	}

}
