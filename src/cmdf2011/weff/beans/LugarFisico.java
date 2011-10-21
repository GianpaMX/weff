package cmdf2011.weff.beans;

public class LugarFisico {

	String lugar_fisico, id_lugar;

	public LugarFisico(String lugar_fisico, String id_lugar) {
		this.lugar_fisico = lugar_fisico;
		this.id_lugar = id_lugar;
	}

	public String getLugarFisico() {
		return lugar_fisico;
	}

	public void setLugarFisico(String lugar_fisico) {
		this.lugar_fisico = lugar_fisico;
	}

	public String getIdLugar() {
		return id_lugar;
	}

	public void setIdLugar(String id_lugar) {
		this.id_lugar = id_lugar;
	}
	
	public String toString(){
		return getLugarFisico();
	}
}
