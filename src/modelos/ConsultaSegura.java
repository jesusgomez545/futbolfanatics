package modelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

public class ConsultaSegura {
	public static ResultSet hacerConsulta(Connection con, String consulta, ArrayList<String> datos)
	{
		PreparedStatement st = null;
		ResultSet resultado = null;
		try {
			st = con.prepareStatement(consulta);
			
			if(datos != null){
				for(int i=0;i < datos.size()/2 ; ++i )
				{
					if(datos.get(2*i).equals(String.class.toString()))
					{
						st.setString((i+1), datos.get(2*i+1));					
					}
					else if(datos.get(2*i).equals(Date.class.toString())){
						st.setDate((i+1), Date.valueOf(datos.get(2*i+1)));
					}
					else if(datos.get(2*i).equals(Time.class.toString())){
						st.setTime((i+1), Time.valueOf(datos.get(2*i+1)));
					}
					else if(datos.get(2*i).equals(Integer.class.toString())){
						st.setInt((i+1), Integer.parseInt(datos.get(2*i+1)));
					}
					else if(datos.get(2*i).equals(Boolean.class.toString())){
						st.setBoolean((i+1), Boolean.valueOf(datos.get(2*i+1)));
					}
					else if(datos.get(2*i).equals(Timestamp.class.toString())){
						st.setBoolean((i+1), Boolean.valueOf(datos.get(2*i+1)));
					}	
				}
			}
			System.out.println("[SECURE QUERY]: Running Query >>> "+st.toString());			
			try{
				resultado = st.executeQuery();
			}catch (PSQLException e)
			{
				return null;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}