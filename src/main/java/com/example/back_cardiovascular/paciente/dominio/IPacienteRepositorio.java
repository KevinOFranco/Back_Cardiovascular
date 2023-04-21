package com.example.back_cardiovascular.paciente.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Long> {
    Paciente findByIdentificacion(String id);
}
