
public class AndaluciaFactory {

	public AndaluciaFactory () {
		
	}
	
	public ElementoAndaluz createElementoAndaluz (String elemento) {
		ElementoAndaluz elementoAndaluz = null;
		
		switch (elemento) {
		case "Flamenco":
			elementoAndaluz = new Flamenco();
			break;
		case "Gazpacho":
			elementoAndaluz = new Gazpacho();
			break;
		case "FeriaDeAbril":
			elementoAndaluz = new FeriaDeAbril();
			break;
		}
		
		return elementoAndaluz;
	}
}
