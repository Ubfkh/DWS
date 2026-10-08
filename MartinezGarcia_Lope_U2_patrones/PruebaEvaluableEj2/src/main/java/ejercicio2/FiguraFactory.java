package ejercicio2;

public class FiguraFactory {

	public Figura createFigura (String figura, String color) {
		Figura figuraCre = null;
		
		switch (figura) {
		case "Circulo":
			figuraCre = new Circulo(color);
			break;
		case "Cuadrado":
			figuraCre = new Cuadrado(color);
			break;
		case "Rectangulo":
			figuraCre = new Rectangulo(color);
			break;
		case "Triangulo":
			figuraCre = new Triangulo(color);
			break;
		}
		
		return figuraCre;
	}
}
