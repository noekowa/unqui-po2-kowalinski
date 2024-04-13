package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoTest {

	private Punto punto1;
	private Punto punto2;
	
	@BeforeEach
	public void setUp() throws Exception{
		punto1 = new Punto();
		punto2 = new Punto(1,2);
	}
	@Test
	public void testMover() {
		punto1.moverA(3,4);
		assertEquals (punto1.getX(), 3);
		assertEquals(punto1.getY(), 4);
	}
	@Test
	public void testSumar() {
		assertEquals(punto2.sumar(punto2).getX(), 2);
		assertEquals(punto2.sumar(punto2).getY(), 4);
	}

}
