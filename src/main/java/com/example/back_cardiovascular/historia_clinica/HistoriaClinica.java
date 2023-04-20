package com.example.back_cardiovascular.historia_clinica;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Data
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private LocalDate date;
    private String familyBackground;
    private float weight;
    private float height;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Enfermero enfermero;
}
