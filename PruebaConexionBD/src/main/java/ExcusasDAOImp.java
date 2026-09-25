import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ExcusasDAOImp implements ExcusasDAO{


	private static String stBasico = "SELECT * FROM excusa_entrega"
									+ " ORDER BY nivel_drama DESC";
	
	private static String stPerroGato = "SELECT * FROM excusa_entrega"
										+ " WHERE (excusa LIKE '%perro%' OR excusa LIKE '%gato%') AND dias_retraso >= 2 AND dias_retraso <= 6"
										+ " ORDER BY dias_retraso DESC";
	
	private static String stSinEntrega = "SELECT * FROM excusa_entrega"
										+ " WHERE fecha_entrega IS NULL AND (credibilidad < 4 AND nivel_drama >= 9)";
	
	private static String stDramaticoNoCreible = "SELECT * FROM excusa_entrega"
												+ " WHERE (nivel_drama >= 8 AND credibilidad <= 3) OR ((dias_retraso > 2 AND dias_retraso < 5) AND excusa LIKE '%perro%')";
	
	private static Conexion connection;
	
	public ExcusasDAOImp () {
		try {
			connection = Conexion.getInstancia();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<ExcusaModel> consultaBasica() throws SQLException {
		
		Connection conn = connection.getConnection();
		
		ArrayList<ExcusaModel> excusas = new ArrayList<ExcusaModel>();
		
		try {
			PreparedStatement pst = conn.prepareStatement(stBasico);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				excusas.add(mapRow(rs));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return excusas;
	}

	@Override
	public Optional<ArrayList> perroGato() throws SQLException {

		Connection conn = connection.getConnection();
		
		ArrayList<ExcusaModel> excusas = new ArrayList<ExcusaModel>();
		
		try {
			PreparedStatement pst = conn.prepareStatement(stPerroGato);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				excusas.add(mapRow(rs));
			}
			
			return Optional.of(excusas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return Optional.empty();
	}

	@Override
	public Optional<ArrayList> sinEntregar() throws SQLException {
		Connection conn = connection.getConnection();
		
		ArrayList excusas = new ArrayList<ExcusaModel>();
		
		try {
			PreparedStatement pst = conn.prepareStatement(stSinEntrega);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				excusas.add(mapRow(rs));
			}
			
			return Optional.of(excusas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return Optional.empty();
	}

	@Override
	public Optional<ArrayList> dramaticoNoCreible() throws SQLException {
Connection conn = connection.getConnection();
		
		ArrayList excusas = new ArrayList<ExcusaModel>();
		
		try {
			PreparedStatement pst = conn.prepareStatement(stDramaticoNoCreible);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				excusas.add(mapRow(rs));
			}
			
			
			return Optional.of(excusas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return Optional.empty();
	}

	
	public ExcusaModel mapRow (ResultSet rs) throws SQLException {
		
		int id;
		String alumno;
		String curso;
		String excusa;
		int dias_retraso;
		int credibilidad;
		Date fecha_entrega;
		boolean aprobada_por_profesor;
		int nivel_drama;
		
		try {
			id = rs.getInt("id");
		} catch (SQLException e) {
			id = (Integer) null;
		}
		try {
			alumno = rs.getString("alumno");
		} catch (SQLException e) {
			alumno = "";
		}
		try {
			curso = rs.getString("curso");
		} catch (SQLException e) {
			curso = "";
		}
		try {
			excusa = rs.getString("excusa");
		} catch (SQLException e) {
			excusa = null;
		}
		try {
			dias_retraso = rs.getInt("dias_retraso");
		} catch (SQLException e) {
			dias_retraso = (Integer) null;
		}
		try {
			credibilidad = rs.getInt("credibilidad");
		} catch (SQLException e) {
			credibilidad = (Integer) null;
		}
		try {
			fecha_entrega = rs.getDate("fecha_entrega");
		} catch (SQLException e) {
			fecha_entrega = null;
		}
		try {
			aprobada_por_profesor = rs.getBoolean("aprobada_por_profesor");
		} catch (SQLException e) {
			aprobada_por_profesor = (Boolean) null;
		}
		try {
			nivel_drama = rs.getInt("nivel_drama");
		} catch (SQLException e) {
			nivel_drama = (Integer) null;
		}
		
		return new ExcusaModel(id, alumno, curso, excusa, dias_retraso, credibilidad, fecha_entrega, aprobada_por_profesor, nivel_drama);
		
	}
}
