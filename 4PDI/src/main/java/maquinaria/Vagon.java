package maquinaria;

class Vagon {

	private int cargaMax;
	private int capacidadActual;
	private String mercancia;
	
	Vagon(int cargaMax, int capacidadActual, String mercancia) {
		super();
		this.cargaMax = cargaMax;
		this.capacidadActual = capacidadActual;
		this.mercancia = mercancia;
	}

	@Override
	public String toString() {
		return "Vagon [cargaMax=" + cargaMax + ", capacidadActual=" + capacidadActual + ", mercancia=" + mercancia
				+ "]";
	}
}
