package cmdf2011.weff.beans;

public class Via {

	String via_captacion, id_via;

	public Via(String viaCaptacion, String idVia) {
		this.id_via = idVia;
		this.via_captacion = viaCaptacion;
	}

	public String getViaCaptacion() {
		return via_captacion;
	}

	public void setVia_captacion(String via_captacion) {
		this.via_captacion = via_captacion;
	}

	public String getIdVia() {
		return id_via;
	}

	public void setIdVia(String id_via) {
		this.id_via = id_via;
	}
	
	public String toString(){
		return getViaCaptacion();
	}
	
	
}
