package com.example.back_cardiovascular.security;

import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.facturador.dominio.Facturador;
import com.example.back_cardiovascular.facturador.dominio.IFacturadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IFacturadorRepositorio facturadorRepositorio;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Facturador facturador = facturadorRepositorio.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return new UserDetailsImpl(facturador);
    }
}
