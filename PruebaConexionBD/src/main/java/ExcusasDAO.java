import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface ExcusasDAO {

	ArrayList<ExcusaModel> consultaBasica () throws SQLException;
	
	Optional<ArrayList> perroGato () throws SQLException;
	
	Optional<ArrayList> sinEntregar () throws SQLException;
	
	Optional<ArrayList> dramaticoNoCreible () throws SQLException;
}
