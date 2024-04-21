package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColeccionadorDeObjetosTest {

	private ColeccionadorDeObjetos unColeccionador;
	private Collection coleccion1;
	private List lista1;
	private ArrayList arrayList1;
	private LinkedList linkedList1;
	
	@BeforeEach
	public void setUp() {
		unColeccionador = new ColeccionadorDeObjetos();
	
		coleccion1 = new ArrayList<>();
		lista1 = new ArrayList<>();
		arrayList1 = new ArrayList<>();
		linkedList1 = new LinkedList<>();
		
		
	}
	@Test
	public void testGetFirsFrom() {
		arrayList1.add(1);
		assertEquals(unColeccionador.getFirstFrom(arrayList1), 1);
	}
	@Test
	public void testAddLast() {
		unColeccionador.addLast(2, arrayList1);
		assertTrue(arrayList1.contains(2));
	}
	@Test
	public void testGetSubCollection() {
		arrayList1.add(1);
		arrayList1.add(2);
		arrayList1.add(3);
		assertEquals(unColeccionador.getSubCollection(arrayList1, 0, 1).size(), 1);
		assertTrue(unColeccionador.getSubCollection(arrayList1, 0, 1).contains(1));
	}
	@Test
	public void testContainsElement() {
		arrayList1.add(1);
		assertTrue(unColeccionador.containsElement(arrayList1, 1));
		linkedList1.add(2);
		assertTrue(unColeccionador.containsElement(linkedList1, 2));
	}

}
