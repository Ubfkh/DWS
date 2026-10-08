package ejercicio1;

import java.util.ArrayList;

public class Tejado {

	private ArrayList<Teja> tejas = new ArrayList();
	private int numTejas;
	
	public Tejado (double area) {
		for (int i=0; i < 19 * area; i++) {
			tejas.add(new Teja());
		}
		
		if (19 * area == (int)(19 * area))
			numTejas = (int)(19 * area);
		else
			numTejas = (int)(19 * area) + 1;
	}
	
	public void darSoporte () {
		
	}
}
