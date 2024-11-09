package com.example.boutique.Controller;

import com.example.boutique.Entity.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "produit-service" , url = "${application.config.produits-url}")
public interface ProduitClient {
   @GetMapping("/boutique/{id}")
   List<Produit> findAllProduitByBoutique(@PathVariable("id") Long idBoutique);
}


