package ar.edu.unq.po2.tp8;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Persona;

class PruebaTest {
	
	private Persona unaPersona;
	

	@BeforeEach
	public void setUp() {
		unaPersona = mock(Persona.class);
		when(unaPersona.getNombre()).thenReturn("sdf");
		
	}
	@Test
	public void testGetNombre() {
		assertEquals(unaPersona.getNombre(),"sdf");
	}
}
