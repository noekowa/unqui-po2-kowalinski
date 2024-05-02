package ar.edu.unq.po2.tp6solid_banco;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Double sueldoNetoMensual;
	public Cliente(String nombre, String apellido, String direccion, Integer edad, Double sueldoNetoMensual) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setEdad(edad);
		this.setSueldoNetoMensual(sueldoNetoMensual);
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	private void setEdad(Integer edad) {
		this.edad = edad;
	}
	private void setSueldoNetoMensual(Double sueldoNetoMensual) {
		this.sueldoNetoMensual = sueldoNetoMensual;
	}
	Double getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}
	
	Integer getEdad() {
		return edad;
	}
	public Double getSueldoNetoAnual() {
		return this.getSueldoNetoMensual() * 12;
	}
	public void solicitarCredito(Banco banco, SolicitudCredito solicitud) {
		banco.registrarSolicitud(solicitud);
	}

	

}
