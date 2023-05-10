package com.example.back_cardiovascular.enfermero.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
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
public class Enfermero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String nombre;
    private String apellidos;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private String sexo;
    private String telefono;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String identificacion;
    private String tipoIdentificacion;
    private String IPS;
    private String especialidad;
    @Column(unique = true)
    private String tarjetaProfesional;
    private String contrasena;

    @JsonIgnore()
    @OneToMany(mappedBy = "enfermero")
    private List<Cita> citas;
    @JsonIgnore()
    @OneToMany(mappedBy = "enfermero")
    private List<HistoriaClinica> medicalHistories;
}
