import java.sql.*;

public class DatabaseConnector {
    public static void main (String [] args){

        Connection conn = null;

        try {

            /* Compilar:
            javac DatabaseConnector.java
            java -cp ".;lib/mysql-connector-j-9.2.0.jar" DatabaseConnector */

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "contraseña");
            

            if (conn != null)
                System.out.println("Por fin");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customers");

            while (rs.next())
                System.out.println(rs.getString("city"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
        }
    }
}