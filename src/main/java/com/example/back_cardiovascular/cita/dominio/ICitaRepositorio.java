package com.example.back_cardiovascular.cita.dominio;

import com.example.back_cardiovascular.cita.aplicacion.response.CitaAgendada;
import com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICitaRepositorio extends JpaRepository<Cita, Long> {

    @Query("SELECT new com.example.back_cardiovascular.cita.aplicacion.response.CitaDisponible(c.intervaloHora, e.nombre) FROM Cita c JOIN c.enfermero e ON e.id = :id WHERE c.date = :date AND c.state = :state")
    List<CitaDisponible> findAvailableSchedule(@Param("id") Long id, @Param("date")LocalDate date, @Param("state") Estado state);

    @Query("SELECT new com.example.back_cardiovascular.cita.aplicacion.response.CitaAgendada(c.intervaloHora, c.paciente) FROM Cita c WHERE c.date = :date AND c.state = :state AND c.enfermero = :enfermero")
    List<CitaAgendada> findAppointments(@Param("enfermero") Enfermero enfermero, @Param("date")LocalDate date, @Param("state") Estado state);

    @Query("SELECT c FROM Cita c WHERE c.intervaloHora = :intervaloHora AND c.enfermero = :enfermero AND c.date = :date")
    Cita buscarPorIntervaloHoraEnfermeroYFecha(@Param("intervaloHora") String intervaloHora, @Param("enfermero") Enfermero enfermero, @Param("date") LocalDate date);
}
