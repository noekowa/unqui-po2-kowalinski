package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	private List<Ingreso> ingresosPercibidos;

	
	public Trabajador() {
		super();
		this.setIngresosPercibidos(new ArrayList<Ingreso>());
	}

	private List<Ingreso> getIngresosPercibidos() {
		return ingresosPercibidos;
	}
	private void setIngresosPercibidos(List<Ingreso> ingresosPercibidos) {
		this.ingresosPercibidos = ingresosPercibidos;
	}
	public void addIngreso(Ingreso ingreso) {
		this.getIngresosPercibidos().add(ingreso);
	}
	public Double getMontoImponible() {
		return getIngresosPercibidos().stream()
				.mapToDouble(ing -> ing.getMontoImponible())
				.sum();
	}
	public Double getImpuestoAPagar() {
		return this.getMontoImponible()*0.02;
	}
	public Double getTotalPercibido() {
		return this.getTotalSinImpuesto() - this.getImpuestoAPagar();
	}
	private Double getTotalSinImpuesto() {
		return this.getIngresosPercibidos().stream()
				.mapToDouble(ing -> ing.getMonto())
				.sum();
	}
	
}
