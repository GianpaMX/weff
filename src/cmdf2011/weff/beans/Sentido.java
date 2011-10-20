package cmdf2011.weff.beans;

public class Sentido {

	String sentido, id_sentido;

	public Sentido(String sentido, String id_sentido) {
		this.id_sentido = id_sentido;
		this.sentido = sentido;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public String getIdSentido() {
		return id_sentido;
	}

	public void setIdSentido(String id_sentido) {
		this.id_sentido = id_sentido;
	}
}
