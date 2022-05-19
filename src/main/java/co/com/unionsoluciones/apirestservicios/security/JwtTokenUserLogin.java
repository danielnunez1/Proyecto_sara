package co.com.unionsoluciones.apirestservicios.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author rblanco on 30/04/22
 **/
public class JwtTokenUserLogin {

    private String login;
    private Collection<? extends GrantedAuthority> authorities;
    private String token;
    private long expira;
    private String expiraStr;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpira() {
        return expira;
    }

    public void setExpira(long expira) {
        this.expira = expira;
    }

    public String getExpiraStr() {
        return expiraStr;
    }

    public void setExpiraStr(String expiraStr) {
        this.expiraStr = expiraStr;
    }
}
