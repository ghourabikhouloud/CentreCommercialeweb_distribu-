package com.example.produit.Controller;


import com.example.produit.Entity.Produit;
import com.example.produit.Service.ProduitSerivceImplements;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Produit")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
    private final ProduitSerivceImplements produitSerivceImplements ;

    @PostMapping("/ajouteProduct")
    public Produit ajouteProduit(@RequestBody Produit produit) {

        return produitSerivceImplements.ajouteProduit(produit);
    }

    @GetMapping("/boutique/{id}")
    public List<Produit> getAllProduitInBoutique(@PathVariable ("id") Long idBoutique) {
    return produitSerivceImplements.getAllProduitInBoutique(idBoutique);
    }


}
