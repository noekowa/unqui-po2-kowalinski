package ar.edu.unq.po2.tp6solid_banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco;
	private Cliente unCliente;
	private AdministradorSolicitudes unAdmSolicitudes;
	private SolicitudCredito unaSolicitud;
	
	@BeforeEach
	public void setUp() {
		this.unAdmSolicitudes = mock(AdministradorSolicitudes.class);
		this.banco = new Banco(unAdmSolicitudes);
		this.unCliente = mock(Cliente.class);
		this.unaSolicitud = mock(SolicitudCredito.class);
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
		banco.registrarSolicitud(unaSolicitud);
		verify(unAdmSolicitudes).registrarSolicitud(unaSolicitud);
	}
}
