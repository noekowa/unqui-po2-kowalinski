package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkTeamTest {

	private WorkTeam aWorkTeam;
	private List<Person> teamMembers;
	private Person member1;
	private Person member2;
	private Person member3;
	private Person member4;
	private Person member5;
	
	@BeforeEach
	public void setUp() throws Exception{
		
		this.member1 = new Person("d", LocalDate.of(2001, 1, 1));
		this.member2 = new Person("f", LocalDate.of(2002, 1, 1));
		this.member3 = new Person("s", LocalDate.of(2003, 1, 1));
		this.member4 = new Person("j", LocalDate.of(2004, 1, 1));
		this.member5 = new Person("k", LocalDate.of(2005, 1, 1));
		
		this.teamMembers = Arrays.asList(member1, member2, member3, member4, member5);
		
		this.aWorkTeam = new WorkTeam("sdf", teamMembers);
		
	}
	@Test
	public void testAverageAge() {
		assertEquals(aWorkTeam.averageAge(), 
				((double)(member1.age()+member2.age()+member3.age()+member4.age()+member5.age())/5));
	}
	@Test
	public void testAverageAgePrint() {
		System.out.println(aWorkTeam.averageAge());
	}
	
	

}
