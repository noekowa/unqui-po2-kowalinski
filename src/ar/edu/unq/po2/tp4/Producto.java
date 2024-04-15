package ar.edu.unq.po2.tp4;

public class Producto {

	private String nombre;
	private Double precio;
	private boolean esPrecioCuidado;
	
	public Producto(String nombre, Double precio, boolean esPrecioCuidado) {
		super();
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setEsPrecioCuidado(esPrecioCuidado);
	}
	
	public Producto(String nombre, Double precio) {
		super();
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setEsPrecioCuidado(false);
	}

	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	private void setPrecio(Double precio) {
		this.precio = precio;
	}
	public boolean esPrecioCuidado() {
		return esPrecioCuidado;
	}
	private void setEsPrecioCuidado(boolean esPrecioCuidado) {
		this.esPrecioCuidado = esPrecioCuidado;
	}
	public void aumentarPrecio(Double aumento) {
		this.setPrecio(this.getPrecio()+ aumento);
	}
	

}
