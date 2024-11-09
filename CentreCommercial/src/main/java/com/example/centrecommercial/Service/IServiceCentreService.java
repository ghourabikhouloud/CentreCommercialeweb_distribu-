package com.example.centrecommercial.Service;

import com.example.centrecommercial.Entity.CentreCommercial;
import com.example.centrecommercial.Entity.FullcentreResponse;

import java.util.List;

public interface IServiceCentreService {

    public CentreCommercial ajouterCentre (CentreCommercial centre);
    public CentreCommercial updateCentre (CentreCommercial centre);

    public void SupprimerCentre(long idCentre);

    public CentreCommercial getCentreById (long idCentre);

    public List<CentreCommercial> getAllCentre();

    public FullcentreResponse getCentreWithBoutiques(long idcentre);
}
