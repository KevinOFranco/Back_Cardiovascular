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
@RequestMapping(path="/paciente") // This means URL's start with /demo (after Application path)
public class PacienteControlador {

    @Autowired
    private PacienteServicio service;
    @SneakyThrows
    @GetMapping(path="/get")
    public @ResponseBody ResponseEntity<Paciente> getPatient (@RequestParam String identificacion) {
        Paciente paciente = service.getPatient(identificacion);
        return ResponseEntity.ok(paciente);
    }

    @SneakyThrows
    @PostMapping(path="/save")
    public @ResponseBody ResponseEntity<Paciente> savePatient (@RequestBody Paciente paciente) {
        log.info("Guardar paciente");
        System.out.println(paciente);
        paciente.setNombre("Manuel");
        return ResponseEntity.ok(service.savePatient(paciente));
    }

    @SneakyThrows
    @PutMapping(path="/update")
    public @ResponseBody ResponseEntity<Paciente> updatePatient (@RequestBody Paciente pacienteRequest) {
        return ResponseEntity.ok(service.getPatient(pacienteRequest.getIdentificacion()));
    }
}
