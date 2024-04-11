package ar.edu.unq.po2.tp3;

public class Cuadrado {

	private Rectangulo rectangle;
	
	public Cuadrado(Punto bottomLeft, float lado) {
		super();
		this.setRectangle(new Rectangulo(bottomLeft, lado, lado));
	}

	private void setRectangle(Rectangulo rectangle) {
		this.rectangle = rectangle;
	}

	private Rectangulo getRectangle() {
		return this.rectangle;
	}
	
	public float area() {
		return this.getRectangle().area();
	}
	public float perimeter() {
		return this.getRectangle().perimeter();
	}
}
