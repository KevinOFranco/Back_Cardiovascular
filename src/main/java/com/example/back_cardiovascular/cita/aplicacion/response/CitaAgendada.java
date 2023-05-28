package com.example.back_cardiovascular.cita.aplicacion.response;

public class CitaAgendada {

    private String hora;
    private Long paciente;

    public CitaAgendada(String hora, Long paciente) {
        this.hora = hora;
        this.paciente = paciente;
    }
    public CitaAgendada(){}
}
