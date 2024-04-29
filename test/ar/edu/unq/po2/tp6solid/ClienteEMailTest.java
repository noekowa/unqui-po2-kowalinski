package ar.edu.unq.po2.tp6solid;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteEMailTest {

	private ClienteEMail cliente;
	private String nombreUsuario = "sdf";
	private String pass = "jkl";
	private IServidor servidor;
	private Conector conector;
	private Administrador adm;
	private Correo correo;
	
	@BeforeEach
	public void setUp() {
		this.nombreUsuario = "sdf";
		this.pass = "jkl";
		this.servidor = mock(ServidorPop.class);
		this.conector = mock(Conector.class);
		this.adm = mock(Administrador.class);
		this.cliente = new ClienteEMail(servidor, conector, adm, nombreUsuario, pass);
		this.correo = mock(Correo.class);
	}
	@Test
	public void testRecibirNuevos() {
		cliente.recibirNuevos();
		verify(servidor).recibirNuevos(nombreUsuario, pass);
	}
	@Test
	public void testEnviarCorreo() {
		cliente.enviarCorreo(correo);
		verify(servidor).enviar(correo);
	}
	@Test
	public void testConectar() {
		verify(conector).conectar(servidor, nombreUsuario, pass);
	}
	@Test
	public void testGetInbox() {
		assertEquals(cliente.getInbox().size(), 0);
	}
	@Test
	public void testGetBorrados() {
		assertEquals(cliente.getBorrados().size(), 0);
	}
}
