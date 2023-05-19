package com.example.back_cardiovascular.cita.dominio;

import com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICitaRepositorio extends JpaRepository<Cita, Long> {

    @Query("SELECT new com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible(c.intervaloHora, e.nombre) FROM Cita c JOIN c.enfermero e ON e.id = :id WHERE c.date = :date")
    List<CitaDisponible> findAvailableSchedule(@Param("id") Long id, @Param("date")LocalDate date);
}
