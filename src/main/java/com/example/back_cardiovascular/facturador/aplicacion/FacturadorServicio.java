package com.example.back_cardiovascular.facturador.aplicacion;

import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import com.example.back_cardiovascular.facturador.aplicacion.request.FacturadorRequest;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturadorServicio {

    private final IEnfermeroRepositorio nurseRepository;

    public boolean save(FacturadorRequest nurseRequest){
        return nurseRepository.save(nurseRequest.transform()) != null;
    }
    public Optional<Enfermero> get(Long id){
        return nurseRepository.findById(id);
    }
    public Optional<Enfermero> get(LoginRequest loginRequest){
        return nurseRepository.findByEmail(loginRequest.getEmail());
    }
}
