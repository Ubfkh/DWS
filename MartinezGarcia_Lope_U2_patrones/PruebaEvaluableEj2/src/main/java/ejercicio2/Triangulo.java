package ejercicio2;

public class Triangulo extends Figura{

	public Triangulo (String color) {
		super(color);
	}
	
	@Override
	public void dibujarFigura() {
		System.out.println("△");
	}
}
