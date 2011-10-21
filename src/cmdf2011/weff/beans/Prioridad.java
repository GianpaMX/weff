package cmdf2011.weff.beans;

public class Prioridad {

	String prioridad, id_prioridad;

	public Prioridad(String prioridad, String id_prioridad) {
		this.id_prioridad = id_prioridad;
		this.prioridad = prioridad;
	}
	
	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getId_prioridad() {
		return id_prioridad;
	}

	public void setId_prioridad(String id_prioridad) {
		this.id_prioridad = id_prioridad;
	}
	
	public String toString(){
		return getPrioridad();
	}
}
