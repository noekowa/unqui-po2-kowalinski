package ar.edu.unq.po2.tp5;

public class Producto {
	
	private Double precio;
	private Integer cantidadEnStock;
	
	
	public Producto(Double precio, Integer cantidadEnStock) {
		super();
		this.setPrecio(precio);
		this.setCantidadEnStock(cantidadEnStock);
	}
	private void setPrecio(Double precio) {
		this.precio = precio;
	}
	private void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	public Double getPrecio() {
		return precio;
	}
	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}
	public void decrementarStock() {
		this.setCantidadEnStock(this.getCantidadEnStock()-1);
	}
	
}
