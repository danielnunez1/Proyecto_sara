package co.com.unionsoluciones.apirestservicios.dtos;

/**
 * @author rblanco on 30/04/22
 **/
public class ErrorDTO {

    private String error;
    private String stackTrace;

    public ErrorDTO(String error) {
        this.error = error;
    }

    public ErrorDTO(String error, String stackTrace) {
        this.error = error;
        this.stackTrace = stackTrace;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
