package ar.edu.unq.po2.tp6solid_banco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	private List<Cliente> clientes;
	private List<SolicitudCredito> solicitudes;
	
	public Banco() {
		super();
		this.setClientes(new ArrayList<Cliente>());
		this.setSolicitudes(new ArrayList<SolicitudCredito>());
	}
	private void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public void setSolicitudes(List<SolicitudCredito> solicitudes) {
		this.solicitudes = solicitudes;
	}
	private List<SolicitudCredito> getSolicitudes() {
		return solicitudes;
	}
	
	public Boolean agregarCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}
	public Boolean registrarSolicitud(SolicitudCredito solicitud) {
		return this.getSolicitudes().add(solicitud);
	}
	public Double montoTotalSolicitudesAceptables() {
		return getSolicitudes().stream()
				.filter(solicitud -> solicitud.esAceptable())
				.collect(Collectors.toList()).stream()
				.mapToDouble(solicitud -> solicitud.getMonto())
				.sum();
	}

}
