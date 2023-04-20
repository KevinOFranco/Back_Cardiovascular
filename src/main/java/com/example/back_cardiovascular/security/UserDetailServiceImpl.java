package com.example.back_cardiovascular.security;

import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IEnfermeroRepositorio nurseRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Enfermero enfermero = nurseRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return new UserDetailsImpl(enfermero);
    }
}
