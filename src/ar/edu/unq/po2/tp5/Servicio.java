package ar.edu.unq.po2.tp5;

public class Servicio extends Factura{
	
	private Double costoPorUnidad;
	private Integer cantidadUnidadesConsumidas;
	
	
	public Servicio(Agencia agencia, Double costoPorUnidad, Integer cantidadUnidadesConsumidas) {
		super(agencia);
		this.setCostoPorUnidad(costoPorUnidad);
		this.setCantidadUnidadesConsumidas(cantidadUnidadesConsumidas);
	}
	private Double getCostoPorUnidad() {
		return costoPorUnidad;
	}
	private void setCostoPorUnidad(Double costoPorUnidad) {
		this.costoPorUnidad = costoPorUnidad;
	}
	private Integer getCantidadUnidadesConsumidas() {
		return cantidadUnidadesConsumidas;
	}
	private void setCantidadUnidadesConsumidas(Integer cantidadUnidadesConsumidas) {
		this.cantidadUnidadesConsumidas = cantidadUnidadesConsumidas;
	}
	@Override
	public Double getMontoAPagar() {
		return this.getCantidadUnidadesConsumidas()*this.getCostoPorUnidad();
	}
	
	

}
