package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoTest {

	private SolicitudCredito solicitudCredPersonal;
	private SolicitudCredito solicitudCredPersonalNoAceptable;
	private Cliente unCliente;
	
	@BeforeEach
	public void setUp() {
		this.unCliente = mock(Cliente.class);
		this.solicitudCredPersonal = new SolicitudCreditoPersonal(unCliente, 15000*0.7, 12);
		this.solicitudCredPersonalNoAceptable = new SolicitudCreditoPersonal(unCliente, 5000.0, 5);
	}
	@Test
	public void testGetMontoCuotaMensual() {
		assertEquals(solicitudCredPersonal.getMontoCuotaMensual(), 15000*0.7/12);
	}
	@Test
	public void testEsAceptableTrue() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(15000.0/12);
		when(unCliente.getSueldoNetoAnual()).thenReturn(15000.0);
		assertTrue(solicitudCredPersonal.EsAceptable());
	}
	@Test
	public void testEsAceptableFalse() {
		
	}

}
