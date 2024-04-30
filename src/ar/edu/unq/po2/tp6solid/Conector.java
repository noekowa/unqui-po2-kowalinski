package ar.edu.unq.po2.tp6solid;

public class Conector {
	
	private IServidor servidor;

	public Conector(IServidor servidor) {
		super();
		this.setServidor(servidor);
	}
	private void setServidor(IServidor servidor) {
		this.servidor = servidor;
	}
	private IServidor getServidor() {
		return servidor;
	}
	public void conectar(String nombreUsuario, String pass){
		this.getServidor().conectar(nombreUsuario, pass);
	}
	public void recibirNuevos(String nombreUsuario, String pass) {
		this.getServidor().recibirNuevos(nombreUsuario, pass);
	}
	public void enviar(Correo correo) {
		this.getServidor().enviar(correo);
	}

}
