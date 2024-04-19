package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {

	private Producto unProducto;
	
	@BeforeEach
	public void setUp() {
		this.unProducto = new Producto(100.0, 1000);
	}
	@Test
	public void testGetPrecio() {
		assertEquals(unProducto.getMontoAPagar(), 100.0);
	}
	@Test
	public void testGetCantidadEnStock() {
		assertEquals(unProducto.getCantidadEnStock(), 1000);
	}
}
