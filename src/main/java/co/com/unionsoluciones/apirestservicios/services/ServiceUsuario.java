package co.com.unionsoluciones.apirestservicios.services;

import co.com.unionsoluciones.apirestservicios.dtos.UsuarioDTO;
import co.com.unionsoluciones.apirestservicios.dtos.UsuarioInsertDTO;
import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import co.com.unionsoluciones.apirestservicios.mybatis.mapper.UsuarioMapper;
import co.com.unionsoluciones.apirestservicios.security.UserDetailsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rblanco on 29/04/22
 **/
@Service
public class ServiceUsuario implements UserDetailsService {

    @Autowired(required = false)
    private UsuarioMapper usuarioMapper;

    public List<UsuarioModel> myQueryByIdUsuarioHijo(Integer limInferior, Integer limSuperior) {
        return usuarioMapper.myQueryByIdUsuarioHijo(limInferior, limSuperior);
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarioMapper.getUsuarios();
    }

    public UsuarioModel getUsuario(Integer idd2) {
        return usuarioMapper.getUsuario(idd2);
    }

    public UsuarioModel myQueryByNombre(String nombre) {
        return usuarioMapper.myQueryByNombre(nombre);
    }

    public Integer lastIdUsuario() {
        Integer i = usuarioMapper.lastIdUsuario();
        return i == null ? 0 : i;
    }

    public UsuarioModel insert(UsuarioInsertDTO usuarioInsertDTO) {

        int idLast = lastIdUsuario() + 1;
        usuarioMapper.insert(
                idLast,
                usuarioInsertDTO.getNombre(),
                usuarioInsertDTO.getApellido(),
                usuarioInsertDTO.getEmpresa(),
                usuarioInsertDTO.getUsuario(),
                usuarioInsertDTO.getClave(),
                usuarioInsertDTO.getRoles(),
                usuarioInsertDTO.getEstado(),
                usuarioInsertDTO.getConexion());

        return getUsuario(idLast);

    }

    public UsuarioModel myQueryByUsuario(String usuario) {
        return usuarioMapper.myQueryByUsuario(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsLogin userDetailsLogin = new UserDetailsLogin(
                usuarioMapper.myQueryByUsuario(username)
        );
        return userDetailsLogin;
    }

}
