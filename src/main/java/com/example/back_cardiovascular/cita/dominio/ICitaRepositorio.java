package com.example.back_cardiovascular.cita.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICitaRepositorio extends JpaRepository<Cita, Long> {


}
