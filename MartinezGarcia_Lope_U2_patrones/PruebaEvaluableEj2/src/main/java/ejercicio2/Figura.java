package ejercicio2;

public abstract class Figura {

	private String color = "";
	
	public Figura (String color) {
		this.color = color;
	}
	
	public abstract void dibujarFigura ();
}
