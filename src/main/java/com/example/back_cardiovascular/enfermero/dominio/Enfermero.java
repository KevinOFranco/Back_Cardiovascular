package com.example.back_cardiovascular.enfermero.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import com.example.back_cardiovascular.usuario.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Enfermero extends Usuario {

    private String IPS;
    private String especialidad;
    @Column(unique = true)
    private String tarjetaProfesional;

    @JsonIgnore()
    @OneToMany(mappedBy = "enfermero")
    private List<Cita> citas;
    @JsonIgnore()
    @OneToMany(mappedBy = "enfermero")
    private List<HistoriaClinica> medicalHistories;
}
