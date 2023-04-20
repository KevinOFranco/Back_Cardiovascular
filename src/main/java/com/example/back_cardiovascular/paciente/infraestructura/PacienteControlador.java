package com.example.back_cardiovascular.paciente.infraestructura;

import com.example.back_cardiovascular.paciente.aplicacion.request.PacienteRequest;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.aplicacion.PacienteServicio;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/patients") // This means URL's start with /demo (after Application path)
public class PacienteControlador {

    @Autowired
    private PacienteServicio service;
    @SneakyThrows
    @PostMapping(path="/get")
    public @ResponseBody ResponseEntity<Paciente> getPatient (@RequestBody PacienteRequest pacienteRequest) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return ResponseEntity.ok(service.getPatient(pacienteRequest.getId()));
    }

    @SneakyThrows
    @PutMapping(path="/update")
    public @ResponseBody ResponseEntity<Paciente> updatePatient (@RequestBody Paciente pacienteRequest) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return ResponseEntity.ok(service.getPatient(pacienteRequest.getId()));
    }
}
