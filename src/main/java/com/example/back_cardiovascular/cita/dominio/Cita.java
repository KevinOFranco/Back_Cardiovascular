package com.example.back_cardiovascular.cita.dominio;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private LocalTime duration;
    private Estado state;
    private String note;
    private String type;
    private String location;
    @ManyToOne
    private Enfermero enfermero;
    @ManyToOne
    private Paciente paciente;
}
