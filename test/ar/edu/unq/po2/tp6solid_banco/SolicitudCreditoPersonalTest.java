package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoPersonalTest {

	private SolicitudCreditoPersonal solicitudCredito;
	private Cliente unCliente;
	
	@BeforeEach
	public void setUp() {
		this.unCliente = mock(Cliente.class);
		this.solicitudCredito = new SolicitudCreditoPersonal(unCliente, 15000*0.7, 12);
	}
	@Test
	public void testEsAceptableTrue() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(15000.0/12);
		when(unCliente.getSueldoNetoAnual()).thenReturn(15000.0);
		assertTrue(solicitudCredito.esAceptable());
	}
	@Test
	public void testEsAceptableFalse() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(14999.99/12);
		when(unCliente.getSueldoNetoAnual()).thenReturn(14999.99);
		assertFalse(solicitudCredito.esAceptable());
	}
}
