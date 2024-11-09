package com.example.authentification1.Controller;

import com.example.authentification1.Entity.Employe;
import com.example.authentification1.Entity.User;
import com.example.authentification1.Repos.IEmployeeRepo;
import com.example.authentification1.Repos.IUserRepo;
import com.example.authentification1.Service.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@ControllerAdvice
@CrossOrigin("http://localhost:4200")
public class AuthController {
    private final AuthentificationService services;
    private final IEmployeeRepo iEmployeeRepo;
    private final IUserRepo iUserRepositries ;

    @PostMapping("/registerEmployee")
    public ResponseEntity<Employe> registerEmployee(@RequestBody Employe employe) { // Cette annotation permet de lier automatiquement les paramètres de la requête aux propriétés d'un objet.
        // Appel à un service pour enregistrer l'étudiant
        Employe savedEmploye = services.registerEmployee(employe);

        // Renvoi de la réponse avec l'étudiant enregistré
        return ResponseEntity.ok(savedEmploye);
    }
    @GetMapping("/checkEmailExists")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = iUserRepositries.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/login")
    public AuthentificationResponse login(@RequestBody User user) {
        return services.login(user.getEmail() , user.getPassword());
    }


}
