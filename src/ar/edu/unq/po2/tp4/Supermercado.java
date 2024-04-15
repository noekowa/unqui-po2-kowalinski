package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private String nombre;
	private String direccion;
	private List<Producto> catalogo;
	
	public Supermercado(String nombre, String direccion) {
		super();
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCatalogo(new ArrayList<Producto>());
		
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	private void setCatalogo(List<Producto> catalogo) {
		this.catalogo = catalogo;
	}
	private List<Producto> getCatalogo() {
		return catalogo;
	}

	public void agregarProducto(Producto prod) {
		this.getCatalogo().add(prod);
		
	}
	public Integer getCantidadDeProductos() {
		return getCatalogo().size();
	}
	public Double getPrecioTotal() {
		return getCatalogo().stream()
				.mapToDouble(prod -> prod.getPrecio())
				.sum();
		
	}
	
	
}
