package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatoTest {

		private List<Plato> listaDePlatos;
		private Plato plato1;
		private Plato plato2;
		private Plato plato3;
		
		@BeforeEach
		public void setUp() throws Exception{

			plato1 = new Plato("s", 100);
			plato2 = new Plato("d", 2000);
			plato3 = new Plato("f", 3000);
			listaDePlatos = Arrays.asList(plato1, plato2, plato3);
		}
		@Test
		public void testSumatoria() {
			assertEquals(plato1.sumatoria(listaDePlatos), 121.00);	
		}
}
