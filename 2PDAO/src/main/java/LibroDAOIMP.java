import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroDAOIMP implements LibroDAO{

	
	ArrayList<Libro> libros = new ArrayList();
	
	@Override
	public List<Libro> obtenerTodos() {
		return libros;
	}

	@Override
	public Optional<Libro> obtenerPorId(int id) {
		
		for (int i=0; i < libros.size(); i++)
			if (libros.get(i).getId() == id)
				return Optional.of(libros.get(i));
		return Optional.empty();
	}

	@Override
	public void agregar(Libro libro) {
		libros.add(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		
		boolean ok = false;
		
		for (int i=0; i < libros.size() && !ok; i++) {
			if (libros.get(i).getId() == libro.getId()) {
				libros.remove(i);
				libros.add(libro);
				ok = true;
			}
		}
		
		if (!ok)
			libros.add(libro);
	}

	@Override
	public void eliminar(int id) {
		
		boolean ok = false;
		
		for (int i=0; i < libros.size() && !ok; i++)
			if (libros.get(i).getId() == id) {
				libros.remove(i);
				ok = true; 
			}
	}
}
