package com.example.back_cardiovascular.enfermero.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@Entity
public class Enfermero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "enfermero")
    private List<Cita> citas;
    @OneToMany(mappedBy = "enfermero")
    private List<HistoriaClinica> medicalHistories;
}
