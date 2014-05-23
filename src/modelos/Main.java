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
		ArrayList<Evento> re = Evento.get(" * ", "nombre_usuario = ?", datos);
		System.out.println(re.get(0).toJson());
		
		System.out.println("==================================");
		
		Evento.update("titulo = 'China vs Argentina :)'", "id = 7", null);
		
		ArrayList<String> datos3 = new ArrayList<String>(); 
		datos3.add(String.class.toString());
		datos3.add("jhon");		
		ArrayList<Registrado> re1 = Registrado.get(" * ", "nombre = ?", datos3);
		System.out.println(re1.get(0).toJson());
		System.out.println(re1.get(1).toJson());
		System.out.println(re1.get(2).toJson());
		
		System.out.println("==================================");
		
		Registrado.update("apellido = 'update'", "nombre = 'jhon'", null);
		
		ArrayList<String> datos2 = new ArrayList<String>(); 
		datos2.add(String.class.toString());
		datos2.add("magle13");
		Registrado.delete("", "nombre_usuario = ?", datos2);
		
		Registrado nuevo = new Registrado("magle389","jhon","gomez",23,"jhon@origin.com","123");
		nuevo.save();
		
		System.out.println("==================================");
		
		ArrayList<Registrado> r1 = Registrado.get(" * ", "", null);
		for( int i=0; i<r1.size();++i)
			System.out.println(r1.get(i).toJson());		
	}

}
