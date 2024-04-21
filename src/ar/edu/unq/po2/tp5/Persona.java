package ar.edu.unq.po2.tp5;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements Nombrable {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		super();
		this.setNombre(nombre);
		this.setFechaNacimiento(fechaNacimiento);
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	public Integer getEdad() {
		return Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
	}

	


}
