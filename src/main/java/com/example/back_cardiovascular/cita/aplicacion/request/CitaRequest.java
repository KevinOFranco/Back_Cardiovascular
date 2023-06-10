package com.example.back_cardiovascular.cita.aplicacion.request;

import com.example.back_cardiovascular.cita.dominio.Estado;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaRequest {

    private Long enfermeroId;
    private LocalDate date;
    private String hora;

    private String type;
    private String location;

    public boolean verifyContent (){
        if (enfermeroId.equals(null) ||  date.isEqual(null)  ) {
            return false;
        }
        return true;
    }
}
