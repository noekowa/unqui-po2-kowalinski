package ar.edu.unq.po2.tp6solid;

public class Conector {
	
	public void conectar(IServidor serv, String nombreUsuario, String pass){
		serv.conectar(nombreUsuario, pass);
	}

}
