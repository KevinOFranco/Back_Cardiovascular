package com.example.back_cardiovascular.paciente.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import com.example.back_cardiovascular.usuario.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Paciente extends Usuario {


    private String direccion;
    private String tipoSangre;
    private String estadoCivil;
    private String eps;
    private String etnia;
    private String genero;
    private String zonaResidencia;
    private String gruposPoblacionales;
    private String ocupacion;

    @JsonIgnore()
    @OneToMany (mappedBy = "paciente")
    private List<HistoriaClinica> historiasClinicas;
    @JsonIgnore()
    @OneToMany (mappedBy = "paciente")
    private List<Cita> citas;
}
