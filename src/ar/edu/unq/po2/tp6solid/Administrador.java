package ar.edu.unq.po2.tp6solid;

public class Administrador {
	
	private ClienteEMail cliente;
	
	private ClienteEMail getCliente() {
		return cliente;
	}

	public void borrarCorreo(Correo correo){
		getCliente().getInbox().remove(correo);
		getCliente().getBorrados().add(correo);
	}
	
	public int contarBorrados(){
		return getCliente().getBorrados().size();
	}
	
	public int contarInbox(){
		return getCliente().getInbox().size();
	}
	
	public void eliminarBorrado(Correo correo){
		getCliente().getBorrados().remove(correo);
	}

}
