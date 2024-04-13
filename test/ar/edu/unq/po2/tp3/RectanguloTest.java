package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectanguloTest {
	
	private Rectangulo unRectangulo;
	private Punto unPunto;
	private float alto;
	private float ancho;
	
	@BeforeEach
	public void setUp() throws Exception{
		unPunto = new Punto(0, 1);
		alto = 1;
		ancho = 2;
		unRectangulo = new Rectangulo(unPunto, alto, ancho);
	}
	@Test
	public void testPosicionDeVertices() {
		assertEquals(unRectangulo.getBottomLeft(), unPunto);
		assertEquals(unRectangulo.getBottomRight().getX(), unPunto.getX()+ancho);
		assertEquals(unRectangulo.getBottomRight().getY(), unPunto.getY());
		assertEquals(unRectangulo.getTopLeft().getX(), unPunto.getX());
		assertEquals(unRectangulo.getTopLeft().getY(), unPunto.getY()+alto);
		assertEquals(unRectangulo.getTopRight().getX(), unPunto.getX()+ancho);
		assertEquals(unRectangulo.getTopRight().getY(), unPunto.getY()+alto);
	}
	@Test
	public void testArea() {
		assertEquals(unRectangulo.area(), alto*ancho);
		assertEquals(unRectangulo.area(), 2);
	}
	@Test
	public void testPerimeter() {
		assertEquals(unRectangulo.perimeter(), alto*2+ancho*2);
		assertEquals(unRectangulo.perimeter(), 6);
	}
	@Test
	public void TestEsHorizontal() {
		assertTrue(unRectangulo.esHorizontal());
	}
}
