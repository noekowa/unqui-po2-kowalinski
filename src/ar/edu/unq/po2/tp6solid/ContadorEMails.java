package ar.edu.unq.po2.tp6solid;

public class ContadorEMails {
	
	public int contarBorrados(ClienteEMail cliente){
		return cliente.getBorrados().size();
	}
	
	public int contarInbox(ClienteEMail cliente){
		return cliente.getInbox().size();
	}
}
