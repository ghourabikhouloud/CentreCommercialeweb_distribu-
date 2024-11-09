package com.example.centrecommercial.Repository;

import com.example.centrecommercial.Entity.CentreCommercial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICentreCommercialRepo extends JpaRepository<CentreCommercial , Long> {
}
