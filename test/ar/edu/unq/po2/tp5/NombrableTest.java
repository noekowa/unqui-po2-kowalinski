package ar.edu.unq.po2.tp5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NombrableTest {

	private Nombrable persona1;
	private Nombrable persona2;
	private Nombrable mascota1;
	private Nombrable mascota2;
	
	private List<Nombrable> coleccion;
	
	@BeforeEach
	public void setUp() {
		persona1 = new Persona("s", LocalDate.of(1986, 8, 7));
		persona2 = new Persona("d", LocalDate.of(1997, 5, 18));
		mascota1 = new Mascota("f", "sdf");
		mascota2 = new Mascota("g", "jkl");
	}
	@Test
	public void testGetNombre() {
		coleccion = Arrays.asList(persona1, persona2, mascota1, mascota2);
		System.out.println (coleccion.stream()
			.map(n -> n.getNombre())
			.toList());
	}
	

}
