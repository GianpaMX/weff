package cmdf2011.weff.beans;

public class Tramo {

	String tramo, id_tramo;

	public Tramo(String tramo, String id_tramo) {
		this.id_tramo = id_tramo;
		this.tramo = tramo;
	}

	public String getTramo() {
		return tramo;
	}

	public void setTramo(String tramo) {
		this.tramo = tramo;
	}

	public String getIdTramo() {
		return id_tramo;
	}

	public void setIdTramo(String id_tramo) {
		this.id_tramo = id_tramo;
	}

	public String toString(){
		return getTramo();
	}
	
}
