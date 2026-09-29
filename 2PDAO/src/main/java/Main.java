
public class Main {

	public static void main (String [] args) {
		
		LibroDAOIMP libros = new LibroDAOIMP();
		
		libros.agregar(new Libro("Mein Kampf", "Adolof Hitler", 1935));
		libros.agregar(new Libro("Manifiesto comunista", "Karl Marx", 1960));
		
		
		libros.obtenerTodos();
		libros.eliminar(2);
	}
}
