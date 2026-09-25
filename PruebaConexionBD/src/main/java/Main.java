import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class Main {

	public static void main (String [] args) {
		
		try {
			Conexion conexion = Conexion.getInstancia();
			Connection conn = conexion.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ExcusasDAOImp excusas = new ExcusasDAOImp();
		
		try {
			Optional<ArrayList> lista = excusas.dramaticoNoCreible();
			
			lista.ifPresent(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
