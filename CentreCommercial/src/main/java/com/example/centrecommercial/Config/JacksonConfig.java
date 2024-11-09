package com.example.centrecommercial.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    //[org.springframework.http.converter.HttpMessageConversionException],com.fasterxml.jackson.databind.exc.InvalidDefinitionException].
    //Cette configuration permettra a jackson de ne pas échouer si la sérialisation d'une classe ne peut pas etre effectué en raison de l'abcesnse de sérialisation
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}
