package ar.edu.unq.po2.tp3;

import java.util.List;

public class Plato {
	
	private String nombre;
	private float precio;
	
	public Plato(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public double sumatoria(List<Plato> listaDePlatos) {
		return listaDePlatos.stream()
		.filter(plato -> plato.getPrecio()*1.21 < 1000)
		.mapToDouble(p -> p.getPrecio()*1.21).sum();
	}
	

}
