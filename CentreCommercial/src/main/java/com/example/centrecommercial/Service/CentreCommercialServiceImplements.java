package com.example.centrecommercial.Service;

import com.example.centrecommercial.Controller.BoutiqueClient;
import com.example.centrecommercial.Entity.CentreCommercial;
import com.example.centrecommercial.Entity.FullcentreResponse;
import com.example.centrecommercial.Repository.ICentreCommercialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CentreCommercialServiceImplements implements IServiceCentreService{
    private final ICentreCommercialRepo iCentreCommercialRepo ;
    private final BoutiqueClient boutiqueClient;
    @Override
    public CentreCommercial ajouterCentre(CentreCommercial centre) {
        return iCentreCommercialRepo.save(centre);
    }

    @Override
    public CentreCommercial updateCentre(CentreCommercial centre) {
        return iCentreCommercialRepo.save(centre);
    }

    @Override
    public void SupprimerCentre(long idCentre) {
        iCentreCommercialRepo.deleteById(idCentre);

    }
    @Override
    public CentreCommercial getCentreById(long idCentre) {
        return iCentreCommercialRepo.getById(idCentre);
    }

    @Override
    public List<CentreCommercial> getAllCentre() {
        return iCentreCommercialRepo.findAll();
    }

    @Override
    public FullcentreResponse getCentreWithBoutiques(long idcentre) {
        var centre = iCentreCommercialRepo.findById(idcentre)
                .orElse(
                        CentreCommercial.builder()
                                .nom("NOT_FOUND")
                                .adresse("NOT_FOUND")
                                .build()
                );
        var boutique = boutiqueClient.findAllBoutiqueByCentre(idcentre);
        return FullcentreResponse.builder()
                .nom(centre.getNom())
                .adresse(centre.getAdresse())
                .boutiques(boutique)
                .build();
    }


}
