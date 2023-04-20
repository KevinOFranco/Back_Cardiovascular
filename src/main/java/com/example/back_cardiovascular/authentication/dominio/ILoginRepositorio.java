package com.example.back_cardiovascular.authentication.dominio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepositorio extends JpaRepository<Enfermero, Long> {

    Enfermero findByEmail(String email);
}

