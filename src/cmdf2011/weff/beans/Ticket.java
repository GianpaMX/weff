package cmdf2011.weff.beans;

public class Ticket {

	String y_calle, asunto, punto_referencia, id_sentido;  
	String fecha_ingreso, descripcion, id_prioridad,  entre_calle; 
	String id_tramo,  id_etapa,  id_area,  id_lugar,  latitud, longitud;
	String id_motivo,  id_tipo,  id_via,  id_ciudadano,  id_ticket;
	
	public String getY_calle() {
		return y_calle;
	}
	public void setY_calle(String y_calle) {
		this.y_calle = y_calle;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getPunto_referencia() {
		return punto_referencia;
	}
	public void setPunto_referencia(String punto_referencia) {
		this.punto_referencia = punto_referencia;
	}
	public String getId_sentido() {
		return id_sentido;
	}
	public void setId_sentido(String id_sentido) {
		this.id_sentido = id_sentido;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getId_prioridad() {
		return id_prioridad;
	}
	public void setId_prioridad(String id_prioridad) {
		this.id_prioridad = id_prioridad;
	}
	public String getEntre_calle() {
		return entre_calle;
	}
	public void setEntre_calle(String entre_calle) {
		this.entre_calle = entre_calle;
	}
	public String getId_tramo() {
		return id_tramo;
	}
	public void setId_tramo(String id_tramo) {
		this.id_tramo = id_tramo;
	}
	public String getId_etapa() {
		return id_etapa;
	}
	public void setId_etapa(String id_etapa) {
		this.id_etapa = id_etapa;
	}
	public String getId_area() {
		return id_area;
	}
	public void setId_area(String id_area) {
		this.id_area = id_area;
	}
	public String getId_lugar() {
		return id_lugar;
	}
	public void setId_lugar(String id_lugar) {
		this.id_lugar = id_lugar;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getId_motivo() {
		return id_motivo;
	}
	public void setId_motivo(String id_motivo) {
		this.id_motivo = id_motivo;
	}
	public String getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(String id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getId_via() {
		return id_via;
	}
	public void setId_via(String id_via) {
		this.id_via = id_via;
	}
	public String getId_ciudadano() {
		return id_ciudadano;
	}
	public void setId_ciudadano(String id_ciudadano) {
		this.id_ciudadano = id_ciudadano;
	}
	public String getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(String id_ticket) {
		this.id_ticket = id_ticket;
	}
	
	public String toString() {
		return "Ticket #" + getId_ticket() + ". " + getDescripcion() + " (" + getFecha_ingreso() + ")";
	}
}
