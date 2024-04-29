package ar.edu.unq.po2.tp6solid;

import java.util.ArrayList;

public class ClienteEMail {
	
	private IServidor servidor;
	private Conector conector;
	private Administrador administrador;
	private String nombreUsuario;
	private String passusuario;
	private ArrayList<Correo> inbox;
	private ArrayList<Correo> borrados;
	
	public ClienteEMail(IServidor servidor, Conector conector, Administrador adm, String nombreUsuario, String pass){
		this.setServidor(servidor);
		this.setConector(conector);
		this.setAdministrador(adm);
		this.setNombreUsuario(nombreUsuario);
		this.setPassusuario(pass);
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.getConector().conectar(getServidor(), getNombreUsuario(), getPassusuario());
	}
	private Conector getConector() {
		return conector;
	}
	private void setConector(Conector conector) {
		this.conector = conector;
	}
	private void setAdministrador(Administrador adm) {
		this.administrador = adm;
	}
	private IServidor getServidor() {
		return servidor;
	}
	private void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}
	private String getNombreUsuario() {
		return nombreUsuario;
	}
	private void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	private String getPassusuario() {
		return passusuario;
	}
	private void setPassusuario(String passusuario) {
		this.passusuario = passusuario;
	}
	public ArrayList<Correo> getInbox() {
		return inbox;
	}
	public ArrayList<Correo> getBorrados() {
		return borrados;
	}
	public void recibirNuevos(){
		this.getServidor().recibirNuevos(getNombreUsuario(), getPassusuario());
	}
	
	public void enviarCorreo(Correo correo){
		this.getServidor().enviar(correo);
	}

}