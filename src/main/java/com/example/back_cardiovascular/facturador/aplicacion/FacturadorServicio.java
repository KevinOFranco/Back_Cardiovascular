package com.example.back_cardiovascular.facturador.aplicacion;

import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import com.example.back_cardiovascular.facturador.aplicacion.request.FacturadorRequest;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.facturador.dominio.Facturador;
import com.example.back_cardiovascular.facturador.dominio.IFacturadorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturadorServicio {

    private final IFacturadorRepositorio facturadorRepositorio;

    public boolean save(Facturador facturador){
        return facturadorRepositorio.save(facturador) != null;
    }
    public Optional<Facturador> get(Long id){
        return facturadorRepositorio.findById(id);
    }
    public Optional<Facturador> get(LoginRequest loginRequest){
        return facturadorRepositorio.findByEmail(loginRequest.getEmail());
    }
}
