package com.example.back_cardiovascular.enfermero.aplicacion;

import com.example.back_cardiovascular.enfermero.aplicacion.request.EnfermeroRequest;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnfermeroServicio {

    private final IEnfermeroRepositorio enfermeroRepositorio;

    public boolean save(Enfermero enfermero){
        return enfermeroRepositorio.save(enfermero) != null;
    }
    public Enfermero get(String id){
        return enfermeroRepositorio.findByIdentificacion(id);
    }

    public List<Enfermero> getAll(){return enfermeroRepositorio.findAll();}
    public Object get(LoginRequest loginRequest){
        return enfermeroRepositorio.findByEmail(loginRequest.getEmail());
    }
}
