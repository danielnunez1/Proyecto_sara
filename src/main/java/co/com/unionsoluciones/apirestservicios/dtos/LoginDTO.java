package co.com.unionsoluciones.apirestservicios.dtos;

/**
 * @author rblanco on 30/04/22
 **/
public class LoginDTO {

    private String correo;
    private String clave;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
