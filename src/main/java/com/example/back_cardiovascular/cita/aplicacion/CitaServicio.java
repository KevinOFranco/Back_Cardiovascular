package com.example.back_cardiovascular.cita.aplicacion;

import com.example.back_cardiovascular.cita.aplicacion.request.CitaRequest;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaAgendada;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible;
import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.cita.dominio.Estado;
import com.example.back_cardiovascular.cita.dominio.ICitaRepositorio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitaServicio {
    private final ICitaRepositorio citaRepositorio;
    private final IEnfermeroRepositorio enfermeroRepositorio;
    private final IPacienteRepositorio pacienteRepositorio;

    public boolean CrearHorarioCita(CitaRequest citaRequest){
        Optional<Enfermero> enfermero = enfermeroRepositorio.findById(citaRequest.getEnfermeroId());
        Cita cita = new Cita();
        cita.setDate(citaRequest.getDate());
        cita.setState(Estado.Scheduled);
        cita.setType(citaRequest.getType());
        cita.setLocation(citaRequest.getLocation());
        cita.setEnfermero(enfermero.get());
        cita= citaRepositorio.save(cita);

        return cita!=null;
    }
    public List<CitaDisponible> getAvailableSchedule(Long id, LocalDate date){
        return citaRepositorio.findAvailableSchedule(id, date, Estado.Confirmed);
    }
    public List<CitaAgendada> getAppointments(Enfermero enfermero, LocalDate date){
        return citaRepositorio.findAppointments(enfermero, date, Estado.Scheduled);
    }
    public Cita buscarPorIntervaloHoraEnfermeroYFecha (String hora, Enfermero enfermero, LocalDate date){
        return citaRepositorio.buscarPorIntervaloHoraEnfermeroYFecha(hora, enfermero, date);
    }
    public Optional<Cita> get(Long id){
        return citaRepositorio.findById(id);
    }
    public void delete(Long id){
        citaRepositorio.deleteById(id);
    }

    public List<Cita> getAll(){
        return citaRepositorio.findAll();
    }

    public void agendarCita(Cita cita) {
        citaRepositorio.save(cita);
    }
}
