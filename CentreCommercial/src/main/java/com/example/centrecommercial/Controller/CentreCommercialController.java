package com.example.centrecommercial.Controller;

import com.example.centrecommercial.Entity.CentreCommercial;
import com.example.centrecommercial.Entity.FullcentreResponse;
import com.example.centrecommercial.Service.IServiceCentreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Centre")
@RestController
@CrossOrigin("*")
public class CentreCommercialController {
    private final IServiceCentreService iServiceCentre ;

    @PostMapping("/ajouteCentre")
    public CentreCommercial ajouterCentre (@RequestBody CentreCommercial centre){
        return iServiceCentre.ajouterCentre(centre);
    }

    @PostMapping("/updateCentre/{id}")
    public CentreCommercial updateCentre (@PathVariable ("id")  long idCentre , @RequestBody  CentreCommercial centre){
        return iServiceCentre.updateCentre(centre);
    }

    @DeleteMapping("/DeleteCentre/{idCentre}")
    public void SupprimerCentre(@PathVariable ("idCentre") long idCentre){
        iServiceCentre.SupprimerCentre(idCentre);
    }

    @GetMapping("/GetCentreById/{id}")
    public CentreCommercial getCentreById (@PathVariable ("id") long idCentre){
      return   iServiceCentre.getCentreById(idCentre);
    }
    @GetMapping("/GetAllCentre")
    public List<CentreCommercial> getAllCentre(){
        return iServiceCentre.getAllCentre();
    }

    @GetMapping("/with-boutique/{id}")
    public FullcentreResponse getCentreWithBoutiques(@PathVariable ("id") long idcentre){
        return iServiceCentre.getCentreWithBoutiques(idcentre);
    }


}
