package com.example.back_cardiovascular.aplication;

import com.example.back_cardiovascular.paciente.aplicacion.PacienteServicio;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PacienteServicioTest {

    private PacienteServicio servicio;

    @Mock
    private IPacienteRepositorio repositorio;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servicio = new PacienteServicio(repositorio);
    }

    @Test
    public void obtenerPaciente_DebeRetornarPacienteExistente() {
        // Arrange
        String identificacion = "1234567890";
        Paciente paciente = new Paciente();
        paciente.setIdentificacion(identificacion);
        when(repositorio.findByIdentificacion(identificacion)).thenReturn(paciente);

        // Act
        Paciente resultado = servicio.getPatient(identificacion);

        // Assert
        verify(repositorio, times(1)).findByIdentificacion(identificacion);
        assertEquals(paciente, resultado);
    }

    @Test
    public void guardarPaciente_DebeRetornarPacienteGuardado() {
        // Arrange
        Paciente paciente = new Paciente();
        when(repositorio.save(paciente)).thenReturn(paciente);

        // Act
        Paciente resultado = servicio.savePatient(paciente);

        // Assert
        verify(repositorio, times(1)).save(paciente);
        assertEquals(paciente, resultado);
    }
}
