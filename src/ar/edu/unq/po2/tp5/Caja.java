package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private List<Chargeable> chargeables;
	
	public Caja() {
		super();
		this.setChargeables(new ArrayList<Chargeable>());
	}
	private void setChargeables(List<Chargeable> chargeables) {
		this.chargeables = chargeables;
	}
	private List<Chargeable> getChargeables() {
		return chargeables;
	}
	public Double getMontoAPagar() {
		return this.getChargeables().stream()
			.mapToDouble(chargeable -> chargeable.getMontoAPagar())
			.sum();
	}
	public void registrarChargeable(Chargeable chargeable) {
		this.getChargeables().add(chargeable);
		chargeable.completarRegistroDeCaja();
	}
}
