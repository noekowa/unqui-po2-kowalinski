package ar.edu.unq.po2.tp6solid;

public class Correo {

	private String asunto;
	private String destinatario;
	private String cuerpo;
	
	public Correo(String asunto, String destinatario, String cuerpo) {
		this.setAsunto(asunto);
		this.setDestinatario(destinatario);
		this.setCuerpo(cuerpo);
	}
	
	private void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	private void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	private void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
}
