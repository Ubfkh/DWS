import maquinaria.Tren;
import personal.Maquinista;

public class Main {

	public static void main (String [] args) {
		Maquinista maquinista = new Maquinista("Paco Pérez Fernández", "12345678M", 2000f, "Veterano");
		
		int[] cantMaxs = {1000, 2000, 3000, 4000, 5000};
		int[] cantActs = {500, 1000, 1500, 2000, 2500};
		String[] mercancias = {"Troncos", "Carbón", "Hierro", "Cobre", "Oro"};
		
		Tren tren = new Tren(maquinista, "ES 1234", "5000 CV", 2020, 5, cantMaxs, cantActs, mercancias);
	}
}
