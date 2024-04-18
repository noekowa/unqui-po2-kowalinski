package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {

	private Producto prod1;
	private ProductoCooperativa prodCoop;
	private Caja unaCaja;
	
	@BeforeEach
	public void setUp() {
		prod1 = new Producto(100.0, 1000);
		prodCoop = new ProductoCooperativa(100.0, 1000);
		unaCaja = new Caja();
	}
	@Test void testCajaSinProductos() {
		assertEquals(unaCaja.getMontoAPagar(), 0.0);
	}
	@Test
	public void testRegistrarProducto() {
		unaCaja.registrarProducto(prod1);
		assertEquals(unaCaja.getMontoAPagar(), 100.0);
		assertEquals(prod1.getCantidadEnStock(), 999);
		unaCaja.registrarProducto(prodCoop);
		assertEquals(unaCaja.getMontoAPagar(), 190.0);
		assertEquals(prodCoop.getCantidadEnStock(), 999);
	}
}
