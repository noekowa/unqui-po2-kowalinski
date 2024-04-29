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
	public Correo() {
		super();
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getAsunto() {
		return asunto;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public String getCuerpo() {
		return cuerpo;
	}
}
