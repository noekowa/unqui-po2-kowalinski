package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {

	private Producto prod1;
	private ProductoCooperativa prodCoop;
	private Servicio unServicio;
	private Impuesto unImpuesto;
	private Agencia unaAgencia;
	private Caja unaCaja;
	
	@BeforeEach
	public void setUp() {
		prod1 = new Producto(100.0, 1000);
		prodCoop = new ProductoCooperativa(100.0, 1000);
		unServicio = new Servicio(unaAgencia, 100.0, 10);
		unImpuesto = new Impuesto(unaAgencia, 100.0);
		
		unaCaja = new Caja();
	}
	@Test void testCajaSinChargeable() {
		assertEquals(unaCaja.getMontoAPagar(), 0);
	}
	@Test
	public void testRegistrarChargeable() {
		unaCaja.registrarChargeable(prod1);
		assertEquals(unaCaja.getMontoAPagar(), 100);
		assertEquals(prod1.getCantidadEnStock(), 999);
		
		unaCaja.registrarChargeable(prodCoop);
		assertEquals(unaCaja.getMontoAPagar(), 100 + 90);
		assertEquals(prodCoop.getCantidadEnStock(), 999);
		
		/**
		 * unaCaja.registrarChargeable(unServicio);
		 * assertEquals(unaCaja.getMontoAPagar(), 100 + 90 + 1000);
		 * 
		 * unaCaja.registrarChargeable(unImpuesto);
		 * assertEquals(unaCaja.getMontoAPagar(), 100 + 90 + 1000 + 100);
		 */
		
		
		
	}
}
