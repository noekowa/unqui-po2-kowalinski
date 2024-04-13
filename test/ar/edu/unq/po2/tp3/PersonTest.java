package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	private Person aPerson;
	private Person aPerson2;
	
	@BeforeEach
	public void setUp() throws Exception{
		this.aPerson = new Person("sdf", LocalDate.of(1986, 8, 7));
		this.aPerson2 = new Person("hjk", LocalDate.of(1986, 8, 6));
	}
	@Test
	public void testGetName() {
		assertEquals(aPerson.getName(), "sdf");
	}
	@Test
	public void testGetDateOfBirth() {
		assertEquals(aPerson.getDateOfBirth(), LocalDate.of(1986, 8, 7));
	}
	@Test
	public void testAge() {
		assertEquals(aPerson.age(), 37);
	}
	@Test
	public void testYoungerThan() {
		assertEquals(aPerson.youngerThan(aPerson2), true);
	}
	
}
