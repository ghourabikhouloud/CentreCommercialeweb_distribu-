package com.example.centrecommercial.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Boutique  {
    @JsonProperty("idBoutique")
    private int idBoutique;
    String nom ;

    String adresse ;

    @Enumerated(EnumType.STRING)
    TypeBoutique typeBoutique ;

    @Enumerated(EnumType.STRING)
    Categorie categorie ;

    String numTel ;
    Long idCentre;
}
