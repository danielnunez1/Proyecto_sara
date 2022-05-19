package co.com.unionsoluciones.apirestservicios.security;

import co.com.unionsoluciones.apirestservicios.StringUtilities;
import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import co.com.unionsoluciones.apirestservicios.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rblanco on 30/04/22
 **/
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            String token = StringUtilities.getInstance().getToken(request);

            if (token != null && jwtProvider.validateToke(token)) {

                String usuario = jwtProvider.getUserTokenIfFromToken(token);

                UsuarioModel usuarioModel = serviceUsuario.myQueryByUsuario(usuario);

                UserDetailsLogin userDetailsLogin = new UserDetailsLogin(
                        usuarioModel
                );

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetailsLogin, null, userDetailsLogin.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        filterChain.doFilter(request, response);
    }
}
