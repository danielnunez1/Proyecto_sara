package co.com.unionsoluciones.apirestservicios;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rblanco on 30/04/22
 **/
public class StringUtilities {

    private static StringUtilities stringUtilities;

    private StringUtilities(){

    }
    public static StringUtilities getInstance(){
        if(stringUtilities == null){
            stringUtilities = new StringUtilities();
        }
        return stringUtilities;
    }
    public String getToken(HttpServletRequest request){
        if(request == null){
            return null;
        }
        //Bearer TOKEN
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){
            return token.replaceFirst("Bearer ", "");
        }
        return null;
    }

}
