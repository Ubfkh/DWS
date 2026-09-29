
public class Libro {

	private static int idCont = 0;
	private int id;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	
	public Libro (String titulo, String autor, int anioPublicacion) {
		
		id = idCont++;
		idCont++;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}

	public int getId() {
		return id;
	}
}
