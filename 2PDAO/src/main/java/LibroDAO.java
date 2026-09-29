import java.util.List;
import java.util.Optional;

public interface LibroDAO {
	
	List<Libro> obtenerTodos ();
	
	Optional<Libro> obtenerPorId (int id);
	
	void agregar (Libro libro);
	
	void actualizar (Libro libro);
	
	void eliminar (int id);
}
