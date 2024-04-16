package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTest {

	private Trabajador unTrabajador;
	private Ingreso ingreso1;
	private Ingreso ingreso2;
	private IngresoHorasExtras unIngresoHorasExtras;
	
	@BeforeEach
	public void setUp() {
		this.ingreso1 = new Ingreso(Month.JANUARY, "concepto", 100.0);
		this.ingreso2 = new Ingreso(Month.FEBRUARY, "concepto", 100.0);
		this.unIngresoHorasExtras = new IngresoHorasExtras(Month.JANUARY, "horas extras", 100.0, 1);
	
		this.unTrabajador = new Trabajador();
	}
	@Test
	public void testGetMontoImponible() {
		assertEquals(unTrabajador.getMontoImponible(), 0.0);
		unTrabajador.addIngreso(ingreso1);
		assertEquals(unTrabajador.getMontoImponible(), 100.0);
		unTrabajador.addIngreso(ingreso2);
		assertEquals(unTrabajador.getMontoImponible(), 200.0);
		unTrabajador.addIngreso(unIngresoHorasExtras);
		assertEquals(unTrabajador.getMontoImponible(), 200.0);
	}
	@Test
	public void testGetImpuestoAPagar() {
		assertEquals(unTrabajador.getImpuestoAPagar(), 0.0);
		unTrabajador.addIngreso(ingreso1);
		assertEquals(unTrabajador.getImpuestoAPagar(), 100*0.02);
		unTrabajador.addIngreso(ingreso2);
		assertEquals(unTrabajador.getImpuestoAPagar(), 200*0.02);
		unTrabajador.addIngreso(unIngresoHorasExtras);
		assertEquals(unTrabajador.getImpuestoAPagar(), 200*0.02);
	}
	
	@Test
	public void testTotalPercibido() {
		assertEquals(unTrabajador.getTotalPercibido(), 0.0);
		unTrabajador.addIngreso(ingreso1);
		assertEquals(unTrabajador.getTotalPercibido(), 100*0.98);
		unTrabajador.addIngreso(ingreso2);
		assertEquals(unTrabajador.getTotalPercibido(), 200*0.98);
		unTrabajador.addIngreso(unIngresoHorasExtras);
		assertEquals(unTrabajador.getTotalPercibido(), 100+200*0.98);
	}
}
