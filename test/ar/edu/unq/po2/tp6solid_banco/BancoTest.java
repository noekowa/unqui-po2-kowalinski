package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco;
	private Cliente unCliente;
	private SolicitudCredito unaSolicitudAceptable;
	private SolicitudCredito unaSolicitudNoAceptable;
	
	@BeforeEach
	public void setUp() {
		this.banco = new Banco();
		this.unCliente = mock(Cliente.class);
		this.unaSolicitudAceptable = mock(SolicitudCredito.class);
		this.unaSolicitudNoAceptable = mock(SolicitudCredito.class);
	}
	
	@Test
	public void testAgregarCliente() {
		/**
		 * c'omo verifico que lo agreg'o si no tengo un getter p'ublico?
		 * ya que el m'etodo add devuelve true if this collection changed as a result of the call,
		 * cambio el retorno del m'etodo agregarCliente,
		 * para que sea el resultado de la llamada al m'etodo add.
		 */
		assertTrue(banco.agregarCliente(unCliente), "el cliente no fue agregado.");
	}
	@Test
	public void testRegistrarSolicitud() {
		assertTrue(banco.registrarSolicitud(unaSolicitudAceptable));
		assertTrue(banco.registrarSolicitud(unaSolicitudNoAceptable));

	}
	@Test
	public void testMontoTotalSolicitudesAceptables() {
		banco.registrarSolicitud(unaSolicitudAceptable);
		when(unaSolicitudAceptable.esAceptable()).thenReturn(true);
		when(unaSolicitudAceptable.getMonto()).thenReturn(1000.0);
		
		assertEquals(banco.montoTotalSolicitudesAceptables(), 1000.0);
		
		banco.registrarSolicitud(unaSolicitudNoAceptable);
		when(unaSolicitudNoAceptable.esAceptable()).thenReturn(false);
		
		assertEquals(banco.montoTotalSolicitudesAceptables(), 1000,0);
	}
}
