package com.example.back_cardiovascular.paciente.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private String civilStatus;
    private String address;
    private String phone;
    private String healthInsurance;
    private String currentMedications;
    @OneToMany (mappedBy = "patient")
    private List<HistoriaClinica> medicalHistories;
    @OneToMany (mappedBy = "patient")
    private List<Cita> citas;
}
