package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {

	private Persona persona1;
	private Persona persona2;
	
	/**
	 * private Nombrable persona1;
	 * no se puede tipar con la interface,
	 * aunque despu'es la variable guarde una instancia de Persona,
	 * porque hay errores cuando uso mensajes espec'ificos de la clase Persona.
	 * Por ejemplo:
	 * The method getFechaNacimiento() is undefined for the type Nombrable.
	 */
	
	@BeforeEach
	public void setUp() {
		persona1 = new Persona("sdf", LocalDate.of(1986, 8, 7));
		persona2 = new Persona("jkl", LocalDate.of(1997, 5, 18));
	}
	@Test
	public void testGetNombre() {
		assertEquals(persona1.getNombre(), "sdf");
	}
	@Test
	public void testGetFechaNacimiento() {
		assertEquals(persona1.getFechaNacimiento(), LocalDate.of(1986, 8, 7));
	}
	@Test
	public void testGetEdad() {
		assertEquals(persona1.getEdad(), 37);
	}
	@Test
	public void testComparacionDeEdades() {
		assertTrue(persona2.getEdad() < persona1.getEdad());
	}

}
