package com.example.back_cardiovascular.security;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Enfermero enfermero;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); //Para roles
    }

    @Override
    public String getPassword() {
        return enfermero.getPassword();
    }

    @Override
    public String getUsername() {
        return enfermero.getEmail();
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

    public String getNombre(){
        return enfermero.getName();
    }
}
