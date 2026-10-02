package personal;

public class JefeEstacion {

	private String nombreCompleto;
	private String dni;
	
	public JefeEstacion(String nombreCompleto, String dni) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "JefeEstacion [nombreCompleto=" + nombreCompleto + ", dni=" + dni + "]";
	}
}
