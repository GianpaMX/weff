package cmdf2011.weff.beans;

public class Ciudadano {

	private String nombre, apellidoP, apellidoM;
	private String sexo;
	private String tel, cel;
	private String calle, numExt, numInt, colonia, cPosta, delegacion;
	
	/**
	 * @param nombre
	 * @param apellidoP
	 * @param apellidoM
	 * @param sexo
	 * @param tel
	 * @param cel
	 * @param calle
	 * @param numExt
	 * @param numInt
	 * @param colonia
	 * @param cPosta
	 * @param delegacion
	 */
	public Ciudadano(String nombre, String apellidoP, String apellidoM,
			String sexo, String tel, String cel, String calle, String numExt,
			String numInt, String colonia, String cPosta, String delegacion) {
		super();
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.sexo = sexo;
		this.tel = tel;
		this.cel = cel;
		this.calle = calle;
		this.numExt = numExt;
		this.numInt = numInt;
		this.colonia = colonia;
		this.cPosta = cPosta;
		this.delegacion = delegacion;
	}	
	
	
	public String getcPosta() {
		return cPosta;
	}
	public void setcPosta(String cPosta) {
		this.cPosta = cPosta;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumExt() {
		return numExt;
	}
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}	

}
