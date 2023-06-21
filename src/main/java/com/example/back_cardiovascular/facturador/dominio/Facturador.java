package com.example.back_cardiovascular.facturador.dominio;

import com.example.back_cardiovascular.usuario.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Facturador extends Usuario {



}
