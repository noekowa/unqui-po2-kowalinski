package ar.edu.unq.po2.tp6solid_banco;

import java.util.ArrayList;
import java.util.List;

public class AdministradorSolicitudes {
	
	private List<SolicitudCredito> solicitudes;
	
	public AdministradorSolicitudes() {
		super();
		this.setSolicitudes(new ArrayList<SolicitudCredito>());
	}
	private List<SolicitudCredito> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<SolicitudCredito> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Boolean registrarSolicitud(SolicitudCredito solicitud) {
		return this.getSolicitudes().add(solicitud);
	}

}
