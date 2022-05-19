package co.com.unionsoluciones.apirestservicios.security;

import co.com.unionsoluciones.apirestservicios.StringUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rblanco on 30/04/22
 **/
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        logger.info("Iniciando validadio de request");
        String token = StringUtilities.getInstance().getToken(request);
        String mensajeError = jwtProvider.getMessageTokenInvalida(token);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                mensajeError != null ? mensajeError : "No Autorizado el toke error desconocido");
    }

}
