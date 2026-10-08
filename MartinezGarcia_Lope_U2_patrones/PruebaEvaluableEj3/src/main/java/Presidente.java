
public final class Presidente {

	private static Presidente presidente;
	
	private String nombre;
	private String apellidos;
	private int anioEleccion;
	
	private Presidente (String nombre, String apellidos, int anioEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anioEleccion = anioEleccion;
	}
	
	public static synchronized Presidente getInstancia (String nombre, String apellidos, int anioEleccion) {
		if (presidente == null)
			presidente = new Presidente(nombre, apellidos, anioEleccion);
		
		return presidente;
	}
	
	public String getNombre () {
		return nombre;
	}
}
