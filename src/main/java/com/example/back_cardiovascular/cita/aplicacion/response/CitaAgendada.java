package com.example.back_cardiovascular.cita.aplicacion.response;

import com.example.back_cardiovascular.paciente.dominio.Paciente;

public class CitaAgendada {

    private String hora;
    private Paciente paciente;

    public CitaAgendada(String hora, Paciente paciente) {
        this.hora = hora;
        this.paciente = paciente;
    }
    public CitaAgendada(){}

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
