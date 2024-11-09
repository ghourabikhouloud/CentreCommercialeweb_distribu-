package com.example.produit.Service;

import com.example.produit.Entity.Produit;
import com.example.produit.Repository.IProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitSerivceImplements implements IServiceProduit {
    private final IProduitRepository iProduitRepository ;

    @Override
    public Produit ajouteProduit(Produit produit) {
        return iProduitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduitInBoutique(Long idBoutique) {
        return iProduitRepository.findAllByIdBoutique(idBoutique);
    }
}
