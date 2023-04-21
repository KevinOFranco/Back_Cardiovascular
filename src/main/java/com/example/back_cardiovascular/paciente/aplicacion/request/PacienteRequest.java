package com.example.back_cardiovascular.paciente.aplicacion.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteRequest {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String email;
    private String identificacion;
    private String tipoIdentificacion;
    private String tipoSangre;
    private String estadoCivil;
    private String EPSRegimen;
}
