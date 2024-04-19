package ar.edu.unq.po2.tp5;

public class Impuesto extends Factura {

	private Double tasa;

	public Impuesto(Agencia agencia, Double tasa) {
		super(agencia);
		this.setTasa(tasa);
	}
	private void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	private Double getTasa() {
		return tasa;
	}
	@Override
	public Double getMontoAPagar() {
		return this.getTasa();
	}
	
	
	
	
	

}
