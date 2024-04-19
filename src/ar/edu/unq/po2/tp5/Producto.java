package ar.edu.unq.po2.tp5;

public class Producto implements Chargeable {
	
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
	protected Double getPrecio() {
		return precio;
	}
	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	@Override
	public Double getMontoAPagar() {
		return this.getPrecio();
	}
	@Override
	public void completarRegistroDeCaja() {
		this.setCantidadEnStock(this.getCantidadEnStock()-1);
	}
	
}
