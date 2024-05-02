package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorSolicitudesTest {

	private AdministradorSolicitudes administradorSolicitudes;
	private SolicitudCredito unaSolicitudAceptable;
	private SolicitudCredito unaSolicitudNoAceptable;

	@BeforeEach
	public void setUp() {
		this.unaSolicitudAceptable = mock(SolicitudCredito.class);
		this.unaSolicitudNoAceptable = mock(SolicitudCredito.class);
		this.administradorSolicitudes = new AdministradorSolicitudes();
		
	}
	@Test
	public void testRegistrarSolicitud() {
		assertTrue(administradorSolicitudes.registrarSolicitud(unaSolicitudAceptable));
		assertTrue(administradorSolicitudes.registrarSolicitud(unaSolicitudNoAceptable));
	}
	@Test
	public void testMontoTotalSolicitudesAceptables() {
		administradorSolicitudes.registrarSolicitud(unaSolicitudAceptable);
		when(unaSolicitudAceptable.esAceptable()).thenReturn(true);
		when(unaSolicitudAceptable.getMonto()).thenReturn(1000.0);
		
		assertEquals(administradorSolicitudes.montoTotalSolicitudesAceptables(), 1000.0);
		
		administradorSolicitudes.registrarSolicitud(unaSolicitudNoAceptable);
		when(unaSolicitudNoAceptable.esAceptable()).thenReturn(false);
		
		assertEquals(administradorSolicitudes.montoTotalSolicitudesAceptables(), 1000,0);
	}
}
