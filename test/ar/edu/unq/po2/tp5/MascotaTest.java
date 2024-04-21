package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MascotaTest {

	private Mascota mascota1;
	
	@BeforeEach
	public void setUp() {
		mascota1 = new Mascota("Oli", "jkl");
	}
	@Test
	public void testGetNombre() {
		assertEquals(mascota1.getNombre(), "Oli");
	}
	@Test
	public void testGetRaza() {
		assertEquals(mascota1.getRaza(), "jkl");
	}

}
