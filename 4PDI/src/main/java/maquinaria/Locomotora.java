package maquinaria;

class Locomotora {

	private String matricula;
	private String potenciaMotor;
	private int anioFabricacion;
	
	Locomotora(String matricula, String potenciaMotor, int anioFabricacion) {
		super();
		this.matricula = matricula;
		this.potenciaMotor = potenciaMotor;
		this.anioFabricacion = anioFabricacion;
	}

	@Override
	public String toString() {
		return "Locomotora [matricula=" + matricula + ", potenciaMotor=" + potenciaMotor + ", anioFabricacion="
				+ anioFabricacion + "]";
	}
}
