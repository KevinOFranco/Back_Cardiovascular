package com.example.back_cardiovascular.infraestructura;

import com.example.back_cardiovascular.enfermero.aplicacion.EnfermeroServicio;
import com.example.back_cardiovascular.paciente.aplicacion.PacienteServicio;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class EnfermeroControladorTest {
    private static final String AUTHORIZATION = "Authorization";
    private static final String TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJleHAiOjE2ODYwNjUwMzUsIm5vbWJyZSI6IkthcmltIn0.8RityPtqiAhPXYovTXsJKvUGzMekaU4KrMIN15Tazu5TMa8MgnogOR6mIgRspR1z4hO0leVWV7Y4amECefrNTg";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnfermeroServicio servicio;

    @BeforeEach
    void setUp() {
    }

    @Test
    void obtenerEnfermero_OK() throws Exception {
        // Arrange
        //Mockito.when(servicio.get(Mockito.any())).thenReturn(new Paciente());

        // Act
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/paciente/get")
                .header(AUTHORIZATION, TOKEN)
                .param("identificacion", "10");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void guardarEnfermero_OK() throws Exception {
        // Arrange
        //Mockito.when(servicio.savePatient(Mockito.any())).thenReturn(new Paciente());
        Paciente paciente = new Paciente();
        paciente.setNombre("Kevin");

        // Act
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/paciente/save")
                .header(AUTHORIZATION, TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(paciente))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void actualizarEnfermero_OK() throws Exception {
        // Arrange
        //Mockito.when(servicio.savePatient(Mockito.any())).thenReturn(new Paciente());
        Paciente paciente = new Paciente();
        paciente.setNombre("Kevin");

        // Act
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/paciente/update")
                .header(AUTHORIZATION, TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(paciente))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
