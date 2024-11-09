package com.example.produit.Repository;

import com.example.produit.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProduitRepository extends JpaRepository<Produit , Long> {
     List<Produit> findAllByIdBoutique (Long idBoutique);
}
