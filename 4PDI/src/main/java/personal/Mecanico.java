package personal;

public class Mecanico {

	private String nombreCompleto;
	private String tlfno;
	private String especialidad;
	
	public Mecanico(String nombreCompleto, String tlfno, String especialidad) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.tlfno = tlfno;
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Mecanico [nombreCompleto=" + nombreCompleto + ", tlfno=" + tlfno + ", especialidad=" + especialidad
				+ "]";
	}
}
