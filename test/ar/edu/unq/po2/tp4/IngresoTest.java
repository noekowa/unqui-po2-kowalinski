package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoTest {

	private Ingreso unIngreso;
	
	@BeforeEach
	public void setUp() {
		this.unIngreso = new Ingreso(Month.JANUARY, "un concepto", 100.0);
	}
	@Test
	public void testGetMontoImponible () {
		assertEquals(unIngreso.getMontoImponible(), 100.0);
	}
}
