package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente;
	private Banco unBanco;
	private SolicitudCredito unaSolicitud;
	
	@BeforeEach
	public void setUp() {
		this.cliente = new Cliente("sdf", "jkl", "456", 46, 100.0);
		this.unBanco = mock(Banco.class);
		this.unaSolicitud = mock(SolicitudCredito.class);
	}
	@Test
	public void testGetSueldoNetoAnual() {
		assertEquals(cliente.getSueldoNetoAnual(), 100*12);
	}
	@Test
	public void testSolicitarCredito() {
		cliente.solicitarCredito(unBanco, unaSolicitud);
		verify(unBanco).registrarSolicitud(unaSolicitud);
	}

}
