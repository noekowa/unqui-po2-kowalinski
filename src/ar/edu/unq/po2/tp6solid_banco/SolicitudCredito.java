package ar.edu.unq.po2.tp6solid_banco;

public abstract class SolicitudCredito {
	
	private Cliente cliente;
	private Double monto;
	private Integer plazoEnMeses;
	
	
	public SolicitudCredito(Cliente cliente, Double monto, Integer plazoEnMeses) {
		super();
		this.setCliente(cliente);
		this.setMonto(monto);
		this.setPlazoEnMeses(plazoEnMeses);
	}
	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	private void setMonto(Double monto) {
		this.monto = monto;
	}
	private void setPlazoEnMeses(Integer plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}
	/**
	 * getters
	 */
	
	protected Cliente getCliente() {
		return cliente;
	}
	protected Double getMonto() {
		return monto;
	}
	protected Integer getPlazoEnMeses() {
		return plazoEnMeses;
	}
	
	
	public Double getMontoCuotaMensual() {
		return getMonto()/getPlazoEnMeses();
	}
	public abstract boolean esAceptable();

}
