package com.example.back_cardiovascular.usuario.dominio;

import com.example.back_cardiovascular.facturador.dominio.Facturador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
