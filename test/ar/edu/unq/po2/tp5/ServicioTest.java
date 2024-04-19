package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioTest {

	private Servicio unServicio;
	private Agencia unaAgencia;
	
	@BeforeEach
	public void setUp() {
		this.unServicio = new Servicio(unaAgencia, 100.0, 10);
	}
	@Test
	public void testGetMontoAPagar() {
		assertEquals(unServicio.getMontoAPagar(), 100*10);
	}
	@Test
	public void testCompletarRegistroDeCaja() {
		/**
		 * no s'e c'omo hacer este test.
		 */
	}
}
