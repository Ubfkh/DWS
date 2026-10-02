
public class Main {

	public static void main (String [] args) {
		AndaluciaFactory factoria = new AndaluciaFactory();
		
		System.out.println(factoria.createElementoAndaluz("Flamenco").describir());
	}
}
