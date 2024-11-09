package com.example.produit.Service;

import com.example.produit.Entity.Produit;

import java.util.List;

public interface IServiceProduit {
    public Produit ajouteProduit (Produit produit);
    List<Produit> getAllProduitInBoutique(Long idBoutique);
}
