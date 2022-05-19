package co.com.unionsoluciones.apirestservicios.dtos;


import java.math.BigDecimal;
import java.util.Date;
/**
 * Representa un registro de un concepto liquidadado como parte de la nomina de un empleado para un periodo
 * @author Union Soluciones Ltda.
 *
 */
public class NominaEmpleadoDTO {

	private static final long serialVersionUID = 1540520438710465771L;
	/** Número de contrato del empleado al que corresponde este registro de nomina*/
	
	private BigDecimal contrato;
	/** Codigo/Llave de la zona economica a la que corresponde */
	
	private String zonaPK;
	private String centroPK;
	private String lineaPK;
	private String unidadPK;
	private String periodo;
	/** Codigo/llave del concepto de nomina ({@link ConceptoDTO})*/
	private Integer concepto;
	/** Determina el origen de pago de la nomina*/
	private String pago;
	private BigDecimal valorConcepto;
	private BigDecimal valorBase;
	private String presupuestal;
	private Date fechaPago;
	private String origen;
	private Integer nivelCalculo;
	private BigDecimal valorConceptoFuera;
	private BigDecimal valorConceptoAjuste;
	private BigDecimal valorBaseFuera;
	private String periodoOrigen;
	private Integer empresa;
	/** Codigo/llave de la entidad de pago ({@link EntidadDTO})*/
	private String entidadPK;
	private String nombreZona;
	private String nombrecentro;
	private String nombrelinea;
	private String llave;
	private String nombrePersona;
	private String conceptoNombre;
	private String conceptoTipo;
	private String conceptoFormulaValor; 
	private String conceptoTipoServicio;
	private String conceptoEmpresa;
	private String entidadNombre;
	private BigDecimal totalDeducido;
	private BigDecimal totalDevengo;
	private BigDecimal totalPeriodo;
	private BigDecimal valorPagado;
	private BigDecimal valorCausado;
	private BigDecimal valorBasePagado;
	private BigDecimal valorBaseCausado;
	private String diferenteFlexible;
	private BigDecimal valorPagadoTercero;
	private BigDecimal valorCausadoTercero;
	private BigDecimal valorTercero;
	private BigDecimal fueraTercero;

	private String origenPO;
	private String unico;

	private String total;
	private boolean totales;
	private BigDecimal valorDedDev;
	private BigDecimal totalPeriodoNomina;
	private BigDecimal totalPeriodoFuera;
	private String sel;
	private BigDecimal ajuste;

	private String tipoServicio;
	private Date fechaAfiliacion;
	private String tipoConcepto;
	private String codigoConcepto;

	private BigDecimal manual;
	private BigDecimal manualEmpleado;
	private BigDecimal manualAplica;
	private BigDecimal valorAjusteAplica;
	private String entidadAux;
	private String proceso;
	public BigDecimal getContrato() {
		return contrato;
	}
	public void setContrato(BigDecimal contrato) {
		this.contrato = contrato;
	}
	public String getZonaPK() {
		return zonaPK;
	}
	public void setZonaPK(String zonaPK) {
		this.zonaPK = zonaPK;
	}
	public String getCentroPK() {
		return centroPK;
	}
	public void setCentroPK(String centroPK) {
		this.centroPK = centroPK;
	}
	public String getLineaPK() {
		return lineaPK;
	}
	public void setLineaPK(String lineaPK) {
		this.lineaPK = lineaPK;
	}
	public String getUnidadPK() {
		return unidadPK;
	}
	public void setUnidadPK(String unidadPK) {
		this.unidadPK = unidadPK;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Integer getConcepto() {
		return concepto;
	}
	public void setConcepto(Integer concepto) {
		this.concepto = concepto;
	}
	public String getPago() {
		return pago;
	}
	public void setPago(String pago) {
		this.pago = pago;
	}
	public BigDecimal getValorConcepto() {
		return valorConcepto;
	}
	public void setValorConcepto(BigDecimal valorConcepto) {
		this.valorConcepto = valorConcepto;
	}
	public BigDecimal getValorBase() {
		return valorBase;
	}
	public void setValorBase(BigDecimal valorBase) {
		this.valorBase = valorBase;
	}
	public String getPresupuestal() {
		return presupuestal;
	}
	public void setPresupuestal(String presupuestal) {
		this.presupuestal = presupuestal;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Integer getNivelCalculo() {
		return nivelCalculo;
	}
	public void setNivelCalculo(Integer nivelCalculo) {
		this.nivelCalculo = nivelCalculo;
	}
	public BigDecimal getValorConceptoFuera() {
		return valorConceptoFuera;
	}
	public void setValorConceptoFuera(BigDecimal valorConceptoFuera) {
		this.valorConceptoFuera = valorConceptoFuera;
	}
	public BigDecimal getValorConceptoAjuste() {
		return valorConceptoAjuste;
	}
	public void setValorConceptoAjuste(BigDecimal valorConceptoAjuste) {
		this.valorConceptoAjuste = valorConceptoAjuste;
	}
	public BigDecimal getValorBaseFuera() {
		return valorBaseFuera;
	}
	public void setValorBaseFuera(BigDecimal valorBaseFuera) {
		this.valorBaseFuera = valorBaseFuera;
	}
	public String getPeriodoOrigen() {
		return periodoOrigen;
	}
	public void setPeriodoOrigen(String periodoOrigen) {
		this.periodoOrigen = periodoOrigen;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public String getEntidadPK() {
		return entidadPK;
	}
	public void setEntidadPK(String entidadPK) {
		this.entidadPK = entidadPK;
	}
	public String getNombreZona() {
		return nombreZona;
	}
	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}
	public String getNombrecentro() {
		return nombrecentro;
	}
	public void setNombrecentro(String nombrecentro) {
		this.nombrecentro = nombrecentro;
	}
	public String getNombrelinea() {
		return nombrelinea;
	}
	public void setNombrelinea(String nombrelinea) {
		this.nombrelinea = nombrelinea;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getConceptoNombre() {
		return conceptoNombre;
	}
	public void setConceptoNombre(String conceptoNombre) {
		this.conceptoNombre = conceptoNombre;
	}
	public String getConceptoTipo() {
		return conceptoTipo;
	}
	public void setConceptoTipo(String conceptoTipo) {
		this.conceptoTipo = conceptoTipo;
	}
	public String getConceptoFormulaValor() {
		return conceptoFormulaValor;
	}
	public void setConceptoFormulaValor(String conceptoFormulaValor) {
		this.conceptoFormulaValor = conceptoFormulaValor;
	}
	public String getConceptoTipoServicio() {
		return conceptoTipoServicio;
	}
	public void setConceptoTipoServicio(String conceptoTipoServicio) {
		this.conceptoTipoServicio = conceptoTipoServicio;
	}
	public String getConceptoEmpresa() {
		return conceptoEmpresa;
	}
	public void setConceptoEmpresa(String conceptoEmpresa) {
		this.conceptoEmpresa = conceptoEmpresa;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public BigDecimal getTotalDeducido() {
		return totalDeducido;
	}
	public void setTotalDeducido(BigDecimal totalDeducido) {
		this.totalDeducido = totalDeducido;
	}
	public BigDecimal getTotalDevengo() {
		return totalDevengo;
	}
	public void setTotalDevengo(BigDecimal totalDevengo) {
		this.totalDevengo = totalDevengo;
	}
	public BigDecimal getTotalPeriodo() {
		return totalPeriodo;
	}
	public void setTotalPeriodo(BigDecimal totalPeriodo) {
		this.totalPeriodo = totalPeriodo;
	}
	public BigDecimal getValorPagado() {
		return valorPagado;
	}
	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}
	public BigDecimal getValorCausado() {
		return valorCausado;
	}
	public void setValorCausado(BigDecimal valorCausado) {
		this.valorCausado = valorCausado;
	}
	public BigDecimal getValorBasePagado() {
		return valorBasePagado;
	}
	public void setValorBasePagado(BigDecimal valorBasePagado) {
		this.valorBasePagado = valorBasePagado;
	}
	public BigDecimal getValorBaseCausado() {
		return valorBaseCausado;
	}
	public void setValorBaseCausado(BigDecimal valorBaseCausado) {
		this.valorBaseCausado = valorBaseCausado;
	}
	public String getDiferenteFlexible() {
		return diferenteFlexible;
	}
	public void setDiferenteFlexible(String diferenteFlexible) {
		this.diferenteFlexible = diferenteFlexible;
	}
	public BigDecimal getValorPagadoTercero() {
		return valorPagadoTercero;
	}
	public void setValorPagadoTercero(BigDecimal valorPagadoTercero) {
		this.valorPagadoTercero = valorPagadoTercero;
	}
	public BigDecimal getValorCausadoTercero() {
		return valorCausadoTercero;
	}
	public void setValorCausadoTercero(BigDecimal valorCausadoTercero) {
		this.valorCausadoTercero = valorCausadoTercero;
	}
	public BigDecimal getValorTercero() {
		return valorTercero;
	}
	public void setValorTercero(BigDecimal valorTercero) {
		this.valorTercero = valorTercero;
	}
	public BigDecimal getFueraTercero() {
		return fueraTercero;
	}
	public void setFueraTercero(BigDecimal fueraTercero) {
		this.fueraTercero = fueraTercero;
	}
	public String getOrigenPO() {
		return origenPO;
	}
	public void setOrigenPO(String origenPO) {
		this.origenPO = origenPO;
	}
	public String getUnico() {
		return unico;
	}
	public void setUnico(String unico) {
		this.unico = unico;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public boolean isTotales() {
		return totales;
	}
	public void setTotales(boolean totales) {
		this.totales = totales;
	}
	public BigDecimal getValorDedDev() {
		return valorDedDev;
	}
	public void setValorDedDev(BigDecimal valorDedDev) {
		this.valorDedDev = valorDedDev;
	}
	public BigDecimal getTotalPeriodoNomina() {
		return totalPeriodoNomina;
	}
	public void setTotalPeriodoNomina(BigDecimal totalPeriodoNomina) {
		this.totalPeriodoNomina = totalPeriodoNomina;
	}
	public BigDecimal getTotalPeriodoFuera() {
		return totalPeriodoFuera;
	}
	public void setTotalPeriodoFuera(BigDecimal totalPeriodoFuera) {
		this.totalPeriodoFuera = totalPeriodoFuera;
	}
	public String getSel() {
		return sel;
	}
	public void setSel(String sel) {
		this.sel = sel;
	}
	public BigDecimal getAjuste() {
		return ajuste;
	}
	public void setAjuste(BigDecimal ajuste) {
		this.ajuste = ajuste;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}
	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}
	public String getTipoConcepto() {
		return tipoConcepto;
	}
	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}
	public String getCodigoConcepto() {
		return codigoConcepto;
	}
	public void setCodigoConcepto(String codigoConcepto) {
		this.codigoConcepto = codigoConcepto;
	}
	public BigDecimal getManual() {
		return manual;
	}
	public void setManual(BigDecimal manual) {
		this.manual = manual;
	}
	public BigDecimal getManualEmpleado() {
		return manualEmpleado;
	}
	public void setManualEmpleado(BigDecimal manualEmpleado) {
		this.manualEmpleado = manualEmpleado;
	}
	public BigDecimal getManualAplica() {
		return manualAplica;
	}
	public void setManualAplica(BigDecimal manualAplica) {
		this.manualAplica = manualAplica;
	}
	public BigDecimal getValorAjusteAplica() {
		return valorAjusteAplica;
	}
	public void setValorAjusteAplica(BigDecimal valorAjusteAplica) {
		this.valorAjusteAplica = valorAjusteAplica;
	}
	public String getEntidadAux() {
		return entidadAux;
	}
	public void setEntidadAux(String entidadAux) {
		this.entidadAux = entidadAux;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	
}
