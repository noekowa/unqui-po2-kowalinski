package ar.edu.unq.po2.tp6solid_banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Cliente> clientes;
	private AdministradorSolicitudes administradorSolicitudes;
	
	public Banco(AdministradorSolicitudes admSolicitudes) {
		super();
		this.setAdministradorSolicitudes(admSolicitudes);
		this.setClientes(new ArrayList<Cliente>());
	}
	private void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	private void setAdministradorSolicitudes(AdministradorSolicitudes admSolicitudes) {
		this.administradorSolicitudes = admSolicitudes;
	}
	private AdministradorSolicitudes getAdministradorSolicitudes() {
		return administradorSolicitudes;
	}
	public Boolean agregarCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}
	public void registrarSolicitud(SolicitudCredito solicitud) {
		this.getAdministradorSolicitudes().registrarSolicitud(solicitud);
	}

}
