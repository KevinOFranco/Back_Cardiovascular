package com.example.back_cardiovascular.facturador.dominio;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFacturadorRepositorio extends JpaRepository<Facturador, Long> {
    Optional<Facturador> findByEmail(String email);
}
