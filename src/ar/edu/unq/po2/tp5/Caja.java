package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private List<Producto> productos;
	private Double montoAPagar;
	
	public Caja() {
		super();
		this.setProductos(new ArrayList<Producto>());
		this.setMontoAPagar(0.0);
	}
	private void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	private void setMontoAPagar(Double montoAPagar) {
		this.montoAPagar = montoAPagar;
	}
	private List<Producto> getProductos() {
		return productos;
	}
	public Double getMontoAPagar() {
		return montoAPagar;
	}
	public void registrarProducto(Producto prod) {
		this.addProducto(prod);
		this.incrementarMontoAPagar(prod.getPrecio());
		this.decrementarStock(prod);
	}
	private void addProducto(Producto prod) {
		this.getProductos().add(prod);
	}
	private void incrementarMontoAPagar(Double precio) {
		this.setMontoAPagar(this.getMontoAPagar() + precio);
	}
	private void decrementarStock(Producto prod) {
		prod.decrementarStock();
	}
}
