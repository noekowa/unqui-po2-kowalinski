package ar.edu.unq.po2.tp3;

public class Rectangulo {

	private Punto bottomLeft;
	private Punto bottomRight;
	private Punto topLeft;
	private Punto topRight;
	
	public Rectangulo(Punto bottomLeft, float alto, float ancho) {
		super();
		this.setBottomLeft(bottomLeft);
		this.setBottomRight(bottomLeft.sumar(new Punto(ancho, 0)));
		this.setTopLeft(bottomLeft.sumar(new Punto(0, alto)));
		this.setTopRight(bottomLeft.sumar(new Punto(ancho, alto)));
	}

	public Punto getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Punto bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Punto getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(Punto bottomRight) {
		this.bottomRight = bottomRight;
	}

	public Punto getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Punto topLeft) {
		this.topLeft = topLeft;
	}

	public Punto getTopRight() {
		return topRight;
	}

	public void setTopRight(Punto topRight) {
		this.topRight = topRight;
	}

	public float area() {
		return this.alto()*this.ancho();
	}

	private float alto() {
		return this.getTopLeft().getY()-this.getBottomLeft().getY();
	}
	private float ancho() {
		return this.getBottomRight().getX()-this.getBottomLeft().getX();
	}

	public float perimeter() {
		return this.alto()*2+this.ancho()*2;
	}

	public Boolean esHorizontal() {
		return this.alto() < this.ancho();
	}
	
}
