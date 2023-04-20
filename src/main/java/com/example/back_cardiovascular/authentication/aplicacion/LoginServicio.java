package com.example.back_cardiovascular.authentication.aplicacion;

import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import com.example.back_cardiovascular.authentication.dominio.ILoginRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServicio {

    private final ILoginRepositorio loginRepository;

    public Enfermero getNurse(LoginRequest loginRequest){
        return loginRepository.findByEmail(loginRequest.getEmail());
    }
}