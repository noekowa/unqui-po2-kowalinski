package ar.edu.unq.po2.tp4;

import java.time.Month;

public class Ingreso {

	private Month mes;
	private String concepto;
	private Double monto;

	public Ingreso(Month mes, String concepto, Double monto) {
		super();
		this.setMes(mes);
		this.setConcepto(concepto);
		this.setMonto(monto);
	}
	private void setMes(Month mes) {
		this.mes = mes;
	}
	private void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	private void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontoImponible() {
		return getMonto();
	}
	public Double getMonto() {
		return this.monto;
	}
	
}
