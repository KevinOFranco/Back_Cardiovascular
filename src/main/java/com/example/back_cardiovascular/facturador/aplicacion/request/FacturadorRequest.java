package com.example.back_cardiovascular.facturador.aplicacion.request;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import lombok.Data;

@Data
public class FacturadorRequest {
    private String name;
    private String email;
    private String password;

    public boolean verifyContent (){
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }
}
