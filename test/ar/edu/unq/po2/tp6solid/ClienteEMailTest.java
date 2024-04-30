package ar.edu.unq.po2.tp6solid;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteEMailTest {

	private ClienteEMail cliente;
	private String nombreUsuario;
	private String pass;
	private IServidor servidor;
	private Conector conector;
	private ContadorEMails contador;
	private Correo correo;
	
	@BeforeEach
	public void setUp() {
		this.nombreUsuario = "sdf";
		this.pass = "jkl";
		this.conector = mock(Conector.class);
		this.contador = mock(ContadorEMails.class);
		this.cliente = new ClienteEMail(conector, contador, nombreUsuario, pass);
		this.correo = mock(Correo.class);
	}
	@Test
	public void testRecibirNuevos() {
		cliente.recibirNuevos();
		verify(conector).recibirNuevos(nombreUsuario, pass);
	}
	@Test
	public void testEnviarCorreo() {
		cliente.enviarCorreo(correo);
		verify(conector).enviar(correo);
	}
	@Test
	public void testConectar() {
		verify(conector).conectar(nombreUsuario, pass);
	}
	@Test
	public void testGetInbox() {
		assertEquals(cliente.getInbox().size(), 0);
	}
	@Test
	public void testGetBorrados() {
		assertEquals(cliente.getBorrados().size(), 0);
	}
	@Test
	public void testBorrarCorreo() {
		cliente.getInbox().add(correo);
		assertTrue(cliente.getInbox().contains(correo), "error correo no agregado.");
		cliente.borrarCorreo(correo);
		assertFalse(cliente.getInbox().contains(correo), "error correo no borrado.");
		assertTrue(cliente.getBorrados().contains(correo), "error correo no agregado en borrados.");
	}
	@Test
	public void testEliminarBorrado() {
		cliente.getBorrados().add(correo);
		assertTrue(cliente.getBorrados().contains(correo), "error correo no agregado.");
		cliente.eliminarBorrado(correo);
		assertFalse(cliente.getBorrados().contains(correo), "error correo no eliminado.");
	}
}
