package com.example.back_cardiovascular.cita.aplicacion.response;

import lombok.Data;

@Data
public class CitaDisponible {
    private String hora;
    private String enfermero;

    public CitaDisponible(String hora, String enfermero) {
        this.hora = hora;
        this.enfermero = enfermero;
    }
    public CitaDisponible(){}
}
