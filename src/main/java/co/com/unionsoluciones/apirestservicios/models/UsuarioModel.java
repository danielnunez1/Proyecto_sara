package co.com.unionsoluciones.apirestservicios.models;

/**
 * @author rblanco on 29/04/22
 **/
public class UsuarioModel {

    private Integer id;
    private String nombre;
    private String apellido;
    private String empresa;
    private String usuario;
    private String clave;
    private String roles;
    private String estado;
    private String conexion;

    public UsuarioModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioModel{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", empresa='").append(empresa).append('\'');
        sb.append(", usuario='").append(usuario).append('\'');
        sb.append(", clave='").append(clave).append('\'');
        sb.append(", roles='").append(roles).append('\'');
        sb.append(", estado='").append(estado).append('\'');
        sb.append(", conexion='").append(conexion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
