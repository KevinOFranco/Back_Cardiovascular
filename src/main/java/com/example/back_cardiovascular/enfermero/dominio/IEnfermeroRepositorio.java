package com.example.back_cardiovascular.enfermero.dominio;

import com.example.back_cardiovascular.paciente.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEnfermeroRepositorio extends JpaRepository<Enfermero, Long> {
    //Nurse findByEmail(String email);
    Optional<Enfermero> findByEmail(String email);
    Enfermero findByIdentificacion(String id);
}
