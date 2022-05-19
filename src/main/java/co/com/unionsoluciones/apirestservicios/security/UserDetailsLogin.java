package co.com.unionsoluciones.apirestservicios.security;

import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author rblanco on 30/04/22
 **/
public class UserDetailsLogin implements UserDetails {

    private final UsuarioModel usuarioModel;
    private final Collection<GrantedAuthority> authorities;

    /**
     * @param usuarioModel
     * @param authorities
     */
    public UserDetailsLogin(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;

        String[] roles = usuarioModel.getRoles().split(",");
        this.authorities = new ArrayList<>();
        for (String rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuarioModel.getClave();
    }

    @Override
    public String getUsername() {
        return usuarioModel.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuarioModel.getEstado().equals("ACTIVO");
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }
}
