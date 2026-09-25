import java.util.Date;

public class ExcusaModel {

	private int id;
	private String alumno;
	private String curso;
	private String excusa;
	private int diasRetraso;
	private int credibilidad;
	private Date fechaEntrega;
	private boolean aprobadaPorProfesor;
	private int nivelDrama;

	public ExcusaModel(int id, String alumno, String curso, String excusa, int diasRetraso, int credibilidad,
			Date fechaEntrega, boolean aprobadaPorProfesor, int nivelDrama) {
		this.id = id;
		this.alumno = alumno;
		this.curso = curso;
		this.excusa = excusa;
		this.diasRetraso = diasRetraso;
		this.credibilidad = credibilidad;
		this.fechaEntrega = fechaEntrega;
		this.aprobadaPorProfesor = aprobadaPorProfesor;
		this.nivelDrama = nivelDrama;
	}
	
	public String toString () {
		return String.format("id: %d, alumno: %s, excusa: %s", id, alumno, excusa);
	}
}
