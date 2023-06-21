package com.example.back_cardiovascular.usuario.dominio;




import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

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
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String identificacion;
    private String tipoIdentificacion;
    private String telefono;
    private String contrasena;
    private String rol;

    // Constructor, getters y setters
}
