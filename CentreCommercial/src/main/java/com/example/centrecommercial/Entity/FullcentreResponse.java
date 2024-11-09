package com.example.centrecommercial.Entity;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullcentreResponse {
    String nom ;
    String adresse ;
    List<Boutique> boutiques;
}
