package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoHipotecarioTest {
	
	private SolicitudCreditoHipotecario solicitudCredito;
	private Cliente unCliente;
	private Propiedad unaPropiedad;
	
	@BeforeEach
	public void setUp() {
		this.unCliente = mock(Cliente.class);
		this.unaPropiedad = mock(Propiedad.class);
		this.solicitudCredito = new SolicitudCreditoHipotecario(unCliente, 1000.0, 10, unaPropiedad);
	}

	@Test
	public void testEsAceptableTrue() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(100/0.5);
		when(unaPropiedad.getValorFiscal()).thenReturn(1000/0.7);
		when(unCliente.getEdad()).thenReturn(64);
		assertTrue(solicitudCredito.esAceptable());
	}
	@Test
	public void testEsAceptableFalse() {
		when(unCliente.getSueldoNetoMensual()).thenReturn(99/0.5);
		assertFalse(solicitudCredito.esAceptable());
	}

}
