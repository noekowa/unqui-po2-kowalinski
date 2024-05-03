package ar.edu.unq.po2.tp6solid_banco;

public class SolicitudCreditoPersonal extends SolicitudCredito {

	public SolicitudCreditoPersonal(Cliente cliente, Double monto, Integer plazoEnMeses) {
		super(cliente, monto, plazoEnMeses);
	}
	@Override
	public boolean esAceptable() {
		return cumpleIngresosMensuales() && cumpleIngresosAnuales();
	}
	private boolean cumpleIngresosMensuales() {
		return getMontoCuotaMensual()<= getCliente().getSueldoNetoMensual()*0.7;
	}
	private boolean cumpleIngresosAnuales() {
		return getCliente().getSueldoNetoAnual()>=15000;
	}

	
	
	

}
