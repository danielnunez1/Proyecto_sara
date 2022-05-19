package co.com.unionsoluciones.apirestservicios.controller;

import co.com.unionsoluciones.apirestservicios.dtos.ErrorDTO;
import co.com.unionsoluciones.apirestservicios.dtos.LoginDTO;
import co.com.unionsoluciones.apirestservicios.dtos.UsuarioDTO;
import co.com.unionsoluciones.apirestservicios.dtos.UsuarioInsertDTO;
import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import co.com.unionsoluciones.apirestservicios.security.JwtProvider;
import co.com.unionsoluciones.apirestservicios.security.JwtTokenUserLogin;
import co.com.unionsoluciones.apirestservicios.services.ServiceUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author rblanco on 30/04/22
 **/
@RestController
@CrossOrigin(value = {"http://localhost:4200"})
@RequestMapping("/authentication")
public class ControllerAuth {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){

        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getCorreo(),
                            loginDTO.getClave()
                    )
            );

            //realiza la autenticacion
            SecurityContextHolder.getContext().setAuthentication(authentication);

            JwtTokenUserLogin token = jwtProvider.generateToken(authentication);

            return new ResponseEntity<>( token , HttpStatus.OK);

        }catch (Exception e ){

            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(
                    new ErrorDTO(e.getMessage(), e.getMessage())
                    , HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/new")
    private ResponseEntity newUsuarioModel(@RequestBody UsuarioInsertDTO usuarioInsertDTO){
        try {

            usuarioInsertDTO.setClave( passwordEncoder.encode(usuarioInsertDTO.getClave()) );

            UsuarioModel usuarioModel = serviceUsuario.insert(usuarioInsertDTO);

            return new ResponseEntity<>( usuarioModel , HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(
                    new ErrorDTO(e.getMessage(), e.getMessage())
                    , HttpStatus.BAD_REQUEST);
        }
    }

}
