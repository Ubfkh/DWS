package ejercicio2;

public class Main {

	
	FiguraFactory figuraFactory = new FiguraFactory();
	
	Figura circulo = figuraFactory.createFigura("Circulo", "Rojo");
	Figura cuadrado = figuraFactory.createFigura("Cuadrado", "Azabache");
	Figura rectangulo = figuraFactory.createFigura("Rectangulo", "Bermellón");
	Figura triangulo = figuraFactory.createFigura("Triangulo", "Bonito");
}
