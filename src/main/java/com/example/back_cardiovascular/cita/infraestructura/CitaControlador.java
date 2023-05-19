package com.example.back_cardiovascular.cita.infraestructura;

import com.example.back_cardiovascular.cita.aplicacion.CitaServicio;
import com.example.back_cardiovascular.cita.aplicacion.request.CitaRequest;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible;
import com.example.back_cardiovascular.enfermero.aplicacion.request.EnfermeroRequest;
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
import java.util.List;

@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/cita")
public class CitaControlador {

    private final CitaServicio citaServicio;

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
}
