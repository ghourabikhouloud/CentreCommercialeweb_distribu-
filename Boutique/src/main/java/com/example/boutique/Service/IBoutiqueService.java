package com.example.boutique.Service;

import com.example.boutique.Entity.Boutique;
import com.example.boutique.Entity.FullBoutiqueResponse;

import java.util.List;

public interface IBoutiqueService {
    public Boutique ajouterBoutique ( Boutique boutique);
    public Boutique updateBoutique (Boutique boutique);


    public Boutique getBoutiqueById (long idB);

    public List<Boutique> getAllBoutique();

    List<Boutique> getallBoutiquesInCentre(long idCentre);

   public FullBoutiqueResponse findBoutiqueWithproduit (Long idBoutique) ;

   public void deleteBoutique (long id );

}
