package com.example.back_cardiovascular.paciente.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Paciente {
    @JsonIgnore()
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String email;
    private String identificacion;
    private String tipoIdentificacion;
    private String tipoSangre;
    private String estadoCivil;
    private String EPSRegimen;
    @JsonIgnore()
    @OneToMany (mappedBy = "paciente")
    private List<HistoriaClinica> historiasClinicas;
    @JsonIgnore()
    @OneToMany (mappedBy = "paciente")
    private List<Cita> citas;
}
