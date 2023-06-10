package com.example.back_cardiovascular.cita.aplicacion.response;

public class CitaResponse {

    private String hora;
    private String nombre;

    public CitaResponse(){}

    public CitaResponse(String hora, String nombre) {
        this.hora = hora;
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
