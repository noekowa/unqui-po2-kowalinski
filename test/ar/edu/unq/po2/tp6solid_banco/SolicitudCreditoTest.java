package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoTest {

	private SolicitudCredito solicitudCredPersonal;
	private SolicitudCredito solicitudCredHipotecario;
	private Cliente unCliente;
	private Propiedad unaPropiedad;
	
	@BeforeEach
	public void setUp() {
		this.unCliente = mock(Cliente.class);
		this.unaPropiedad = mock(Propiedad.class);
		this.solicitudCredPersonal = new SolicitudCreditoPersonal(unCliente, 12000.0, 12);
		this.solicitudCredHipotecario = new SolicitudCreditoHipotecario(unCliente, 1000.0, 10, unaPropiedad);
	}
	@Test
	public void testGetMontoCuotaMensual() {
		assertEquals(solicitudCredPersonal.getMontoCuotaMensual(), 12000/12);
		assertEquals(solicitudCredHipotecario.getMontoCuotaMensual(), 1000.0/10);
	}
}
