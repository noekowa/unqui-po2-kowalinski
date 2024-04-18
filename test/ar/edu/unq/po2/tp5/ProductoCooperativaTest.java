package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoCooperativaTest {

	private ProductoCooperativa unProdCoop;
	
	@BeforeEach
	public void setUp() {
		unProdCoop = new ProductoCooperativa(100.0, 1000);
	}
	@Test
	public void testGetPrecio() {
		assertEquals(unProdCoop.getPrecio(), 90.0);
	}
	@Test
	public void testGetCantidadEnStock() {
		assertEquals(unProdCoop.getCantidadEnStock(), 1000);
	}

}
