package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuadradoTest {

	private Cuadrado aSquare;
	private Punto aPoint;
	private float sideLength;
	
	@BeforeEach
	public void setUp() throws Exception{
		this.aPoint = new Punto();
		this.sideLength = 1;
		this.aSquare = new Cuadrado(aPoint, sideLength);
	}
	@Test
	public void testArea() {
		assertEquals(aSquare.area(), sideLength*sideLength);
	}
	@Test
	public void testPerimeter() {
		assertEquals(aSquare.perimeter(), 4*sideLength);
	}
	
}
