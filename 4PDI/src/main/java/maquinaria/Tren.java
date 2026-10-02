package maquinaria;

import java.util.ArrayList;
import personal.Maquinista;

public class Tren {

	private Locomotora locomotora;
	private ArrayList<Vagon> vagones = new ArrayList();
	private Maquinista maquinista;
	
	public Tren (Maquinista maquinista, String matriculaLocomotora, String potenciaLocomotora, int anioLocomotora, int cantVagones, int[] cargaMaxVag, int[] cargaActVag, String[] mercanciaVag) {
		this.maquinista = maquinista;
		
		locomotora = new Locomotora(matriculaLocomotora, potenciaLocomotora, anioLocomotora);
		
		for (int i=0; i < cantVagones; i++) {
			vagones.add(new Vagon(cargaMaxVag[i], cargaActVag[i], mercanciaVag[i]));
		}
	}
}
