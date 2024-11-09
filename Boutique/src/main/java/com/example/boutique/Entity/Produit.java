package com.example.boutique.Entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {
    private String nomP ;
    private long prix ;
    private long quantite ;
    private long idProduit;
    Long idBoutique ;

}
