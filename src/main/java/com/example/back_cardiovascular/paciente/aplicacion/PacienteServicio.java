package com.example.back_cardiovascular.paciente.aplicacion;

import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServicio {

    private final IPacienteRepositorio patientRepository;

    public Paciente getPatient(String id){
        return patientRepository.findByIdentificacion(id);
    }

    public Paciente savePatient(Paciente paciente){
        return patientRepository.save(paciente);
    }
}
