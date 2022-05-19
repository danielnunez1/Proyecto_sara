package co.com.unionsoluciones.apirestservicios.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rblanco on 30/04/22
 **/
@Component
public class JwtProvider {

    @Value(value = "${jwt.minutosexpira}")
    private int minutosExpira;

    @Value(value = "${jwt.secret}")
    private String secret;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getUserTokenIfFromToken(String token) throws Exception{
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    /**
     *
     * @param authentication
     * @return
     */
    public JwtTokenUserLogin generateToken(Authentication authentication){

        UserDetailsLogin userDatailsLogin = (UserDetailsLogin)authentication.getPrincipal();

        Calendar cExpira = Calendar.getInstance();
        cExpira.add(Calendar.MINUTE, minutosExpira);

        Map<String, Object> mapClaims = new HashMap<>();
        mapClaims.put("id", userDatailsLogin.getUsuarioModel().getId());
        mapClaims.put("usuario", userDatailsLogin.getUsuarioModel().getUsuario());
        mapClaims.put("nombres", userDatailsLogin.getUsuarioModel().getNombre());
        mapClaims.put("estado", userDatailsLogin.getUsuarioModel().getEstado());
        mapClaims.put("roles", userDatailsLogin.getUsuarioModel().getRoles());
        mapClaims.put("apellido", userDatailsLogin.getUsuarioModel().getApellido());
        mapClaims.put("conexion", userDatailsLogin.getUsuarioModel().getConexion());
        mapClaims.put("empresa", userDatailsLogin.getUsuarioModel().getEmpresa());


        String jwtToken = Jwts.builder()
                .setSubject(userDatailsLogin.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(cExpira.getTime())
                .signWith(SignatureAlgorithm.HS512, secret)
                .addClaims(mapClaims)
                .compact();

        JwtTokenUserLogin jwtTokenUserLogin =  new JwtTokenUserLogin();
        jwtTokenUserLogin.setToken(jwtToken);
        jwtTokenUserLogin.setLogin(userDatailsLogin.getUsername());
        jwtTokenUserLogin.setAuthorities(userDatailsLogin.getAuthorities());
        jwtTokenUserLogin.setExpira(cExpira.getTimeInMillis());
        jwtTokenUserLogin.setExpiraStr(cExpira.getTime().toString());

        return jwtTokenUserLogin;
    }

    /**
     *
     * @param token
     * @param key
     * @return
     */
    public String getClaimValueFromKey(String token, String key){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get(key).toString();
    }
    /**
     *
     * @param token
     * @return
     */
    public boolean validateToke(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException e){
            logger.error(e.getMessage(), e);
        }catch (SignatureException e){
            logger.error(e.getMessage(), e);
        }catch (UnsupportedJwtException e){
            logger.error(e.getMessage(), e);
        }catch (MalformedJwtException e){
            logger.error(e.getMessage(), e);
        }catch (IllegalArgumentException e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public String getMessageTokenInvalida(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return "";
        }catch (ExpiredJwtException e){
            logger.error(e.getMessage(), e);
            return "ExpiredJwtException";
        }catch (SignatureException e){
            logger.error(e.getMessage(), e);
            return "SignatureException";
        }catch (UnsupportedJwtException e){
            logger.error(e.getMessage(), e);
            return "UnsupportedJwtException";
        }catch (MalformedJwtException e){
            logger.error(e.getMessage(), e);
            return "MalformedJwtException";
        }catch (IllegalArgumentException e){
            logger.error(e.getMessage(), e);
            return "IllegalArgumentException";
        }
    }
}
