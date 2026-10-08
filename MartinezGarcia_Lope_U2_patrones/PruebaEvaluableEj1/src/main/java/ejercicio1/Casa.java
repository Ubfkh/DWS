package ejercicio1;

import java.util.ArrayList;

public class Casa {

	private double area;
	private Tejado tejado;
	private ArrayList<Pared> paredes= new ArrayList();
	
	public Casa (double area, double altura) {
		
		for  (int i=0; i < 4; i++) {
			paredes.add(new Pared(altura));
		}
		
		this.area = area;
		
		tejado = new Tejado(area);
	}
}
