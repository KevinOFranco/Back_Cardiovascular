package com.example.back_cardiovascular.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Data;

@Data
public class MessageResponse {
    private String message;

    public String apply(String message) {
        this.message = message;
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
