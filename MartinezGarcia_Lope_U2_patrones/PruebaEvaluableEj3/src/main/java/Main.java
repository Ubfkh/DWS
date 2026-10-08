
public class Main {

	public static void main (String [] args) {
		
		Presidente presidente = Presidente.getInstancia("Antonio", "Segura Ramos", 2020);
		
		System.out.println(presidente.getNombre());
		
		presidente = Presidente.getInstancia("Pepe", "Fernández Romero", 2012);
		
		System.out.println(presidente.getNombre());
	}
}
