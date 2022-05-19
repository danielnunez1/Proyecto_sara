package co.com.unionsoluciones.apirestservicios.dtos;

/**
 * @author rblanco on 27/04/22
 **/
public class PersonaInsertDTO {

    private String nombre;
    private String apellido;

    public PersonaInsertDTO() {
    }

    public PersonaInsertDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
}
