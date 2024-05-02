package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoTest {

	private SolicitudCredito solicitudCredPersonal;
	private SolicitudCredito solicitudCredPersonalNoAceptable;
	private SolicitudCredito solicitudCredHipotecario;
	private SolicitudCredito solicitudCredHipotecarioNoAceptable;
	private Cliente unCliente;
	private Propiedad unaPropiedad;
	
	@BeforeEach
	public void setUp() {
		this.unCliente = mock(Cliente.class);
		this.unaPropiedad = mock(Propiedad.class);
		this.solicitudCredPersonal = new SolicitudCreditoPersonal(unCliente, 15000*0.7, 12);
		this.solicitudCredPersonalNoAceptable = new SolicitudCreditoPersonal(unCliente, 5000.0, 5);
		this.solicitudCredHipotecario = new SolicitudCreditoHipotecario(unCliente, 1000.0, 10, unaPropiedad);
	}
	@Test
	public void testGetMontoCuotaMensual() {
		assertEquals(solicitudCredPersonal.getMontoCuotaMensual(), 15000*0.7/12);
		assertEquals(solicitudCredHipotecario.getMontoCuotaMensual(), 1000.0/10);
		
	}
	@Test
	public void testEsAceptablePersonalTrue() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(15000.0/12);
		when(unCliente.getSueldoNetoAnual()).thenReturn(15000.0);
		assertTrue(solicitudCredPersonal.esAceptable());
	}
	@Test
	public void testEsAceptableHipotecarioTrue() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(100/0.5);
		when(unaPropiedad.getValorFiscal()).thenReturn(1000/0.7);
		when(unCliente.getEdad()).thenReturn(64);
		assertTrue(solicitudCredHipotecario.esAceptable());
	}
	@Test
	public void testEsAceptablePersonalFalse() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(14999.99/12);
		when(unCliente.getSueldoNetoAnual()).thenReturn(14999.99);
		assertFalse(solicitudCredPersonal.esAceptable());
		/**
		 * esAceptable si cumpleIngresosMensuales() && cumpleCondicionesEspecificas().
		 * Para poder testear esAcerpable(), esos dos m'etodos tienen que est'ar implementados
		 * en la subclase solicitudCreditoPersonal.
		 */
		
	}

}
