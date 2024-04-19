package ar.edu.unq.po2.tp5;

public abstract class Factura implements Chargeable{

	private Agencia agencia;
	
	public Factura(Agencia agencia) {
		super();
		this.setAgencia(agencia);
	}

	private Agencia getAgencia() {
		return agencia;
	}

	private void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public abstract Double getMontoAPagar();

	@Override
	public void completarRegistroDeCaja() {
		this.getAgencia().registrarPago(this);
	}
	
}
