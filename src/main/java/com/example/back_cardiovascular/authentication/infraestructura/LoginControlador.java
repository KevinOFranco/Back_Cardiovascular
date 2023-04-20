package com.example.back_cardiovascular.authentication.infraestructura;
import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import com.example.back_cardiovascular.authentication.aplicacion.LoginServicio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/login") // This means URL's start with /demo (after Application path)
public class LoginControlador {

    private final LoginServicio service;
    @SneakyThrows
    @PostMapping(path="/get")
    public @ResponseBody ResponseEntity getNurse (@RequestBody LoginRequest loginRequest) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ResponseEntity<?> finalResponse;
        MessageResponse message = new MessageResponse();
        if (loginRequest.getEmail().isEmpty() || loginRequest.getPassword().isEmpty()) {
            return new ResponseEntity<>(message.apply("Debe agregar los datos de ingreso"), HttpStatus.BAD_REQUEST);
        }
        Enfermero enfermero = service.getNurse(loginRequest);
        finalResponse = enfermero == null ? new ResponseEntity<>(message.apply("El usuario no existe"), HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(enfermero, HttpStatus.OK);
        return finalResponse;
    }

}
