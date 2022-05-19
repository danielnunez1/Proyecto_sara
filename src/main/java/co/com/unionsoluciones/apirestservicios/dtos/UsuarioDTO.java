package co.com.unionsoluciones.apirestservicios.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class UsuarioDTO {
	
	private static final long serialVersionUID = -7934070305810985176L;
	private String login;
	private String nombre;
	private String clave;
	private String email;
	private Date expiracion;
	private String estado;
	private String llaveGrupoAcceso;
	private String claves;
	private Date fechaClave;
	private Integer intentos;
	private BigDecimal cedula;
	private String documento;
	private String parametroBusqueda;
	private String pin;
	private Integer intentosPregunta;
	private String tokenRecuperacion;
	private String terminosYCondiciones;
	private Date  fechaTerminosYCondiciones;
	private Date fechaHabilitar;
	private String llaveEmpresa;
	private String checkAyuda;
	//parametro usado para el cambio de clave
	private String loginEmail;
	
	/**
	 * Empleado para habilitar la edicion de los campos de la tabla usuario
	 * En la configuracion de sara prime, este campo no es persistente.
	 */
	private boolean modificarCelda;
	
	/**
	 * Se utiliza para conocer si el usuario debe cambiar la clave
	 * en el proximo login 
	 */
	private String cambiarClave;
	
	/**
	 * Usado para cargar el rol del usario en sara prime.
	 */
	private String rolGrupal;
	
	/*
	 *  Atributos no persistentes
	 */
	
	private String filtroGeneral;
	
	
	public String getClaves() {
		return claves;
	}

	public void setClaves(String claves) {
		this.claves = claves;
	}

	public Date getFechaClave() {
		return fechaClave;
	}

	public void setFechaClave(Date fechaClave) {
		this.fechaClave = fechaClave;
	}

	public String getLlaveGrupoAcceso() {
		return llaveGrupoAcceso;
	}

	public void setLlaveGrupoAcceso(String llaveGrupoAcceso) {
		this.llaveGrupoAcceso = llaveGrupoAcceso;
	}

	public String getAlias() {
		return "Usuario";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setExpiracion(Date expiracion) {
		this.expiracion = expiracion;
	}

	public Date getExpiracion() {
		return expiracion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}
	
	public BigDecimal getCedula() {
		return cedula;
	}

	public void setCedula(BigDecimal cedula) {
		this.cedula = cedula;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getParametroBusqueda() {
		return parametroBusqueda;
	}

	public void setParametroBusqueda(String parametroBusqueda) {
		this.parametroBusqueda = parametroBusqueda;
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Integer getIntentosPregunta() {
		return intentosPregunta;
	}

	public void setIntentosPregunta(Integer intentosPregunta) {
		this.intentosPregunta = intentosPregunta;
	}

	/* FIN */
	
	public String getTokenRecuperacion() {
		return tokenRecuperacion;
	}
	
	public void setTokenRecuperacion(String tokenRecuperacion) {
		this.tokenRecuperacion = tokenRecuperacion;
	}

	public String getTerminosYCondiciones() {
		return terminosYCondiciones;
	}

	public void setTerminosYCondiciones(String terminosYCondiciones) {
		this.terminosYCondiciones = terminosYCondiciones;
	}

	public Date getFechaTerminosYCondiciones() {
		return fechaTerminosYCondiciones;
	}

	public void setFechaTerminosYCondiciones(Date fechaTerminosYCondiciones) {
		this.fechaTerminosYCondiciones = fechaTerminosYCondiciones;
	}

	public String getCambiarClave() {
		return cambiarClave;
	}

	public void setCambiarClave(String cambiarClave) {
		this.cambiarClave = cambiarClave;
	}

	public Date getFechaHabilitar() {
		return fechaHabilitar;
	}

	public void setFechaHabilitar(Date fechaHabilitar) {
		this.fechaHabilitar = fechaHabilitar;
	}

	public boolean isModificarCelda() {
		return modificarCelda;
	}

	public void setModificarCelda(boolean modificarCelda) {
		this.modificarCelda = modificarCelda;
	}

	public String getRolGrupal() {
		return rolGrupal;
	}

	public void setRolGrupal(String rolGrupal) {
		this.rolGrupal = rolGrupal;
	}

	public String getFiltroGeneral() {
		return filtroGeneral;
	}

	public void setFiltroGeneral(String filtroGeneral) {
		this.filtroGeneral = filtroGeneral;
	}

	public String getLlaveEmpresa() {
		return llaveEmpresa;
	}

	public void setLlaveEmpresa(String llaveEmpresa) {
		this.llaveEmpresa = llaveEmpresa;
	}

	public String getCheckAyuda() {
		return checkAyuda;
	}

	public void setCheckAyuda(String checkAyuda) {
		this.checkAyuda = checkAyuda;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	
}
