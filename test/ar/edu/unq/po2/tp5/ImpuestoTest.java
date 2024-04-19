package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImpuestoTest {

	private Impuesto unImpuesto;
	private Agencia unaAgencia;
	
	@BeforeEach
	public void setUp() {
		unImpuesto = new Impuesto(unaAgencia, 100.0);
	}
	@Test
	public void testGetMontoAPagar() {
		assertEquals(unImpuesto.getMontoAPagar(), 100.0);
	}
	@Test
	public void testCompletarRegistroDeCaja() {
		/**
		 * no s'e c'omo hacer este test.
		 */
	}

}
