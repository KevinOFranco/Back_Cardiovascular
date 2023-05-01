package com.example.back_cardiovascular.cita.aplicacion.request;

import com.example.back_cardiovascular.cita.dominio.Estado;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaRequest {

    Long enfermeroId;
    Long pacienteId;
    private LocalDate date;
    private LocalTime time;
    private LocalTime duration;
    private String note;
    private String type;
    private String location;

    public boolean verifyContent (){
        if (enfermeroId.equals(null) || pacienteId.equals(null) || date.isEqual(null) || time.equals(null) || duration.equals(null) ) {
            return false;
        }
        return true;
    }
}
