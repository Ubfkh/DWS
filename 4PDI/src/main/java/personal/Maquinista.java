package personal;

public class Maquinista {

	private String nombreCompleto;
	private String dni;
	private float sueldo;
	private String rango;
	
	public Maquinista(String nombreCompleto, String dni, float sueldo, String rango) {
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.sueldo = sueldo;
		this.rango = rango;
	}

	@Override
	public String toString() {
		return "Maquinista [nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", sueldo=" + sueldo + ", rango="
				+ rango + "]";
	}
}
