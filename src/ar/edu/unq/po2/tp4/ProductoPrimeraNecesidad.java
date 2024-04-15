package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto{
	
	private Double porcentajeDescuento;

	public ProductoPrimeraNecesidad(String nombre, Double precio, boolean esPrecioCuidado, Double porcentajeDescuento) {
		super(nombre, precio, esPrecioCuidado);
		this.setPorcentajeDescuento(porcentajeDescuento);
	}

	private void setPorcentajeDescuento(Double PorcentajeDescuento) {
		this.porcentajeDescuento = PorcentajeDescuento;
	}

	@Override
	public Double getPrecio() {
		return super.getPrecio()*(1 - this.porcentajeDescuento / 100);
	}
}
