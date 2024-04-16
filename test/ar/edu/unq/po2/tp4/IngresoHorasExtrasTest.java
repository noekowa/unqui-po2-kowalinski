package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoHorasExtrasTest {

	private IngresoHorasExtras unIngresoHorasExtras;
	
	@BeforeEach
	public void setUp() {
		this.unIngresoHorasExtras = new IngresoHorasExtras(Month.JANUARY, "horasExtras", 100.0, 1);
	}

	@Test
	public void testGetMontoImponible() {
		assertEquals(unIngresoHorasExtras.getMontoImponible(), 0.0);
	}
}
