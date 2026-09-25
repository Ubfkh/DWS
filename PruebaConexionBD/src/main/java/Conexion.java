import java.sql.*;

public final class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/excusas";
    private static String user = "root";
    private static String password = "contraseña";

    private static Conexion instancia;
    private Connection connection;

    public Conexion () {

    }

    public static synchronized  Conexion getInstancia () throws SQLException{
        if (instancia == null)
            instancia = new Conexion();
        return instancia;
    }

    public synchronized Connection getConnection () throws SQLException {
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
    
    public boolean close () throws SQLException {
    	if (connection != null && !connection.isClosed())
    		connection.close();
    	return connection == null || connection.isClosed();
    }
}
