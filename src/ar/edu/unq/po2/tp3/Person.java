package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private String name;
	private LocalDate dateOfBirth;
	
	public Person(String name, LocalDate dateOfBirth) {
		super();
		this.setName(name);
		this.setDateOfBirth(dateOfBirth);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	private void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int age() {
		return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
	}
	public Boolean youngerThan(Person person) {
		return this.getDateOfBirth().isAfter(person.getDateOfBirth());
		
	}
}
