package ar.edu.unq.po2.tp6solid;

import java.util.ArrayList;

public class ClienteEMail {
	
	private Conector conector;
	private ContadorEMails contador;
	private String nombreUsuario;
	private String passusuario;
	private ArrayList<Correo> inbox;
	private ArrayList<Correo> borrados;
	
	public ClienteEMail(Conector conector, ContadorEMails contador, String nombreUsuario, String pass){
		this.setConector(conector);
		this.setContador(contador);
		this.setNombreUsuario(nombreUsuario);
		this.setPassusuario(pass);
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.getConector().conectar(getNombreUsuario(), getPassusuario());
	}
	private Conector getConector() {
		return conector;
	}
	private void setConector(Conector conector) {
		this.conector = conector;
	}
	private void setContador(ContadorEMails contador) {
		this.contador = contador;
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
		this.getConector().recibirNuevos(getNombreUsuario(), getPassusuario());
	}
	public void enviarCorreo(Correo correo){
		this.getConector().enviar(correo);
	}

	public void borrarCorreo(Correo correo){
		this.getInbox().remove(correo);
		this.getBorrados().add(correo);
	}
	public void eliminarBorrado(Correo correo){
		this.getBorrados().remove(correo);
	}
}