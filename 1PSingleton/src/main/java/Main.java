
public class Main {

	public static void main (String [] args) {
		
		Configurador confg = Configurador.obtenerInstancia();
		
		confg.setConfiguracion("Jimmy, Paco, Pepe y Virginia");
		
		System.out.println(confg.getConfiguracion());
	}
}
