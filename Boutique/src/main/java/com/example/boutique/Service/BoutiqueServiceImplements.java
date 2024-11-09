package com.example.boutique.Service;

import com.example.boutique.Controller.ProduitClient;
import com.example.boutique.Entity.Boutique;
import com.example.boutique.Entity.Categorie;
import com.example.boutique.Entity.FullBoutiqueResponse;
import com.example.boutique.Entity.TypeBoutique;
import com.example.boutique.Repository.IBoutiqueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BoutiqueServiceImplements implements IBoutiqueService {

    private final IBoutiqueRepo iBoutiqueRepo ;
    private final ProduitClient produitClient;
    @Override
    public Boutique ajouterBoutique(Boutique boutique) {
        return iBoutiqueRepo.save(boutique);
    }

    @Override
    public Boutique updateBoutique(Boutique boutique) {
        return iBoutiqueRepo.save(boutique);
    }


    @Override
    public Boutique getBoutiqueById(long idB) {
       return iBoutiqueRepo.findById(idB).orElse(null);
    }

    @Override
    public List<Boutique> getAllBoutique() {
        return iBoutiqueRepo.findAll();
    }


    @Override
    public List<Boutique> getallBoutiquesInCentre(long idCentre) {
        return iBoutiqueRepo.findAllByIdCentre(idCentre);
    }

//    @Override
//    public FullBoutiqueResponse getBoutiqueWithproduit(Long idBoutique) {
//        var boutique = iBoutiqueRepo.findById(idBoutique)
//                .orElse(
//                        Boutique.builder()
//                                .nom("Not Found")
//                                .adresse("Not Found")
//                                .numTel("Not Found")
//                                .categorie(Categorie.NOM_DEFINI)
//                                .typeBoutique(TypeBoutique.NOM_DEFINI)
//                                .build()
//                );
//        var produit = produitClient.findAllProduitByBoutique(idBoutique);
//        return FullBoutiqueResponse.builder()
//                .nom(boutique.getNom())
//                .adresse(boutique.getAdresse())
//                .numTel(boutique.getNumTel())
//                .typeBoutique(boutique.getTypeBoutique())
//                .categorie(boutique.getCategorie())
//                .produits(produit)
//                .build();
//    }
@Override
public FullBoutiqueResponse findBoutiqueWithproduit(Long idBoutique) {
    var boutique = iBoutiqueRepo.findById(idBoutique)
            .orElse(
                    Boutique.builder()
                            .nom("Not Found")
                            .adresse("Not Found")
                            .build()
            );
    var produit = produitClient.findAllProduitByBoutique(idBoutique);
    return FullBoutiqueResponse.builder()
            .nom(boutique.getNom())
            .adresse(boutique.getAdresse())
            .produits(produit)
            .build();
}

    @Override
    public void deleteBoutique(long id) {
         iBoutiqueRepo.deleteById(id);
    }
}

