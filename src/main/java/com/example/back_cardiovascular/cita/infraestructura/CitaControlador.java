package com.example.back_cardiovascular.cita.infraestructura;

import com.example.back_cardiovascular.cita.aplicacion.CitaServicio;
import com.example.back_cardiovascular.cita.aplicacion.request.CitaRequest;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaAgendada;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaResponse;
import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.cita.dominio.Estado;
import com.example.back_cardiovascular.enfermero.aplicacion.EnfermeroServicio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.paciente.aplicacion.PacienteServicio;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/cita")
public class CitaControlador {

    private final CitaServicio citaServicio;

    private final EnfermeroServicio enfermeroServicio;

    private final PacienteServicio pacienteServicio;

    @SneakyThrows
    @PostMapping(path="/crearHorario")
    public @ResponseBody ResponseEntity saveCita (@RequestBody CitaRequest citaRequest) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ResponseEntity<?> finalResponse;
        MessageResponse message = new MessageResponse();
        if (!citaRequest.verifyContent()) {
            return new ResponseEntity<>(message.apply("Debe agregar los datos de ingreso"), HttpStatus.BAD_REQUEST);
        }

        finalResponse = citaServicio.CrearHorarioCita(citaRequest) ? new ResponseEntity<>(message.apply("Usuario creado satisfactoriamente"), HttpStatus.CREATED) :
                new ResponseEntity<>(message.apply("Message:Usuario ya existente"), HttpStatus.LOCKED);
        return finalResponse;
    }
    @SneakyThrows
    @GetMapping(path="/schedule")
    public @ResponseBody ResponseEntity<List<CitaDisponible>> getSchedule (@RequestParam("id") Long identificacion,
                                                                           @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
        List<CitaDisponible> available = citaServicio.getAvailableSchedule(identificacion, date);
        return ResponseEntity.ok(available);
    }
    @SneakyThrows
    @GetMapping(path="/confirmed")
    public @ResponseBody ResponseEntity<List<CitaResponse>> getAppointments (@RequestParam("id") Long identificacion,
                                                                           @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
        Optional<Enfermero> enfermero = enfermeroServicio.findById(identificacion);
        List<CitaAgendada> agendas = citaServicio.getAppointments(enfermero.get(), date);
        List<CitaResponse> agendasResponse = new ArrayList<>();
        for (CitaAgendada agenda: agendas) {
            agendasResponse.add(new CitaResponse(agenda.getHora(),agenda.getPaciente().getNombre()));
        }
        return ResponseEntity.ok(agendasResponse);
    }


    @SneakyThrows
    @GetMapping(path="/agendar")
    public @ResponseBody ResponseEntity<String> agendarCita (@RequestParam("enfermeroId") Long enfermeroId,
                                                             @RequestParam("pacienteId") Long pacienteId,
                                                             @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date,
                                                             @RequestParam("time") String hora) {
        Optional<Enfermero> enfermero = enfermeroServicio.findById(enfermeroId);
        Cita cita = citaServicio.buscarPorIntervaloHoraEnfermeroYFecha(hora, enfermero.get(),date);
        if (cita != null) {
            Optional<Paciente> paciente = pacienteServicio.findById(pacienteId);
            cita.setPaciente(paciente.get());
            cita.setState(Estado.Scheduled);
            citaServicio.agendarCita(cita);
        }

        return ResponseEntity.ok("");
    }
}
