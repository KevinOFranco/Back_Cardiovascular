package com.example.back_cardiovascular.security;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.facturador.dominio.Facturador;
import com.example.back_cardiovascular.usuario.dominio.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Usuario facturador;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); //Para roles
    }

    @Override
    public String getPassword() {
        return facturador.getContrasena();
    }

    @Override
    public String getUsername() {
        return facturador.getEmail();
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
        return true;
    }

    public String getNombre(){return facturador.getNombre();}

    public String getRol(){return facturador.getRol();}


}
