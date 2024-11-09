package com.example.centrecommercial.Controller;

import com.example.centrecommercial.Entity.Boutique;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="boutique-service", url = "${application.config.boutiques-url}")

public interface BoutiqueClient {
    @GetMapping("Centre/{idCentre}")
    List<Boutique> findAllBoutiqueByCentre(@PathVariable("idCentre")long idCentre);
}
