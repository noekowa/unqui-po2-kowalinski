package ar.edu.unq.po2.tp6solid_banco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public Double montoTotalSolicitudesAceptables() {
		return getSolicitudes().stream()
				.filter(solicitud -> solicitud.esAceptable())
				.collect(Collectors.toList()).stream()
				.mapToDouble(solicitud -> solicitud.getMonto())
				.sum();
	}

}
