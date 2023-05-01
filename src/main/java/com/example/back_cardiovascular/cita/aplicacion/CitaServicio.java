package com.example.back_cardiovascular.cita.aplicacion;

import com.example.back_cardiovascular.cita.aplicacion.request.CitaRequest;
import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.cita.dominio.Estado;
import com.example.back_cardiovascular.cita.dominio.ICitaRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitaServicio {
    private final ICitaRepositorio citaRepositorio;
    private final IEnfermeroRepositorio enfermeroRepositorio;
    private final IPacienteRepositorio pacienteRepositorio;

    public boolean save(CitaRequest citaRequest){
        Optional<Enfermero> enfermero = enfermeroRepositorio.findById(citaRequest.getEnfermeroId());
        Optional<Paciente> paciente = pacienteRepositorio.findById(citaRequest.getPacienteId());
        Cita cita = new Cita();
        cita.setDate(citaRequest.getDate());
        cita.setTime(citaRequest.getTime());
        cita.setDuration(citaRequest.getDuration());
        cita.setState(Estado.Scheduled);
        cita.setNote(citaRequest.getNote());
        cita.setType(citaRequest.getType());
        cita.setLocation(citaRequest.getLocation());
        cita.setEnfermero(enfermero.get());
        cita.setPaciente(paciente.get());
        citaRepositorio.save(cita);
        return true;
    }
}
