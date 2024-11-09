//package com.example.centrecommercial.Config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringDocConfig {
//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI().info(infoAPI());
//    }
//
//    public io.swagger.v3.oas.models.info.Info infoAPI() {
//        return new Info().title("Application Web distribué").description("Gestion Centre commercial").contact(contactAPI());
//    }
//
//    public Contact contactAPI() {
//        Contact contact = new Contact().name("Equipe Aymen").email("aymen.nefzi@esprit.tn").url("https://www.linkedin.com/in/aymen-nefzi-831b6321b/");
//        return contact;
//    }
//
//    @Bean
//    public GroupedOpenApi CENTRE() {
//        return GroupedOpenApi.builder().group("CENTRE").pathsToMatch("/Centre/**").pathsToExclude("**").build();
//    }
//
//
//
//}
