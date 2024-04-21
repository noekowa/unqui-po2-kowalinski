package ar.edu.unq.po2.tp5;

public class Mascota implements Nombrable {

	private String nombre;
	private String raza;
	
	public Mascota(String nombre, String raza) {
		super();
		this.setNombre(nombre);
		this.setRaza(raza);
	}
	public String getRaza() {
		return raza;
	}
	private void setRaza(String raza) {
		this.raza = raza;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String getNombre() {
		return nombre;
	}
}
