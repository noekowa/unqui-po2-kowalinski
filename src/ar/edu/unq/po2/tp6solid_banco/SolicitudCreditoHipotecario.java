package ar.edu.unq.po2.tp6solid_banco;

public class SolicitudCreditoHipotecario extends SolicitudCredito {
	
	private Propiedad propiedadEnGarantia;

	public SolicitudCreditoHipotecario(Cliente cliente, Double monto, Integer plazoEnMeses, Propiedad propEnGarantia) {
		super(cliente, monto, plazoEnMeses);
		this.setPropiedadEnGarantia(propEnGarantia);
	}

	private void setPropiedadEnGarantia(Propiedad propiedadEnGarantia) {
		this.propiedadEnGarantia = propiedadEnGarantia;
	}

	private Propiedad getPropiedadEnGarantia() {
		return propiedadEnGarantia;
	}
	
	@Override
	public boolean esAceptable() {
		return cumpleIngresosMensuales() &&
				cumpleValorGarantia() &&
				cumpleEdad();
	}

	
	private boolean cumpleIngresosMensuales() {
		return getMontoCuotaMensual() <= getCliente().getSueldoNetoMensual()*0.5;
	}
	
	private boolean cumpleValorGarantia() {
		return getMonto() <= getPropiedadEnGarantia().getValorFiscal()*0.7;
	}

	private boolean cumpleEdad() {
		return getCliente().getEdad()+plazoEnAnios() <= 65;
	}

	private float plazoEnAnios() {
		return getPlazoEnMeses()/12;
	}
}
