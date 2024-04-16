package ar.edu.unq.po2.tp4;

import java.time.Month;

public class IngresoHorasExtras extends Ingreso{
	
	private Integer cantHorasExtras;

	public IngresoHorasExtras(Month mes, String concepto, Double monto, Integer cantHorasExtras) {
		super(mes, concepto, monto);
		this.setCantHorasExtras(cantHorasExtras);
	}

	private Integer getCantHorasExtras() {
		return cantHorasExtras;
	}

	private void setCantHorasExtras(Integer cantHorasExtras) {
		this.cantHorasExtras = cantHorasExtras;
	}

	@Override
	public Double getMontoImponible() {
		return 0.0;
	}

}
