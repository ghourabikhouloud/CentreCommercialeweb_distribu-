package com.example.boutique.Repository;

import com.example.boutique.Entity.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBoutiqueRepo extends JpaRepository<Boutique , Long> {
    List<Boutique> findAllByIdCentre(long idCentre);
}
