package com.example.authentification1.Service;

import com.example.authentification1.Controller.AuthentificationResponse;
import com.example.authentification1.Entity.Employe;
import com.example.authentification1.Entity.Role;
import com.example.authentification1.Entity.User;
import com.example.authentification1.Repos.IEmployeeRepo;
import com.example.authentification1.Repos.IUserRepo;
import com.example.authentification1.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImplements implements AuthentificationService {
    private final IUserRepo iUserRepo ;
    private final IEmployeeRepo iEmployeeRepo ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager ;
    @Override
    public Employe registerEmployee(Employe employe) {
        employe.setPassword(passwordEncoder.encode(employe.getPassword()));
        employe.setRole(Role.EMPLOYE);
        return iEmployeeRepo.save(employe);
    }
    public boolean emailExists(String email) {
        // Logique pour vérifier si l'e-mail existe déjà dans la base de données
        return iUserRepo.existsByEmail(email);
    }

    @Override
    public AuthentificationResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        var user = iUserRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("utilisateur non trouvé"));
        var jwt = jwtService.generateToken(user);

        AuthentificationResponse authenticationResponse = new AuthentificationResponse();
        authenticationResponse.setToken(jwt);

        if (user.getRole() == Role.EMPLOYE) {
            Employe employe = (Employe) user;
            Employe employeDto = convertToEmployeDto(employe);
            authenticationResponse.setUser(employeDto);
        } else {
            User userDetails = convertToUserDto(user);
            authenticationResponse.setUser(userDetails);
        }

        return authenticationResponse;
    }

    private User convertToUserDto(User user) {
        User dto = new User();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    private Employe convertToEmployeDto(Employe employe) {
        Employe dto = new Employe();
        dto.setId(employe.getId());
        dto.setNom(employe.getNom());
        dto.setPrenom(employe.getPrenom());
        dto.setEmail(employe.getEmail());
        dto.setPassword(employe.getPassword());
        dto.setRole(employe.getRole());
        dto.setCin(employe.getCin());
//        dto.setDateNaissance(employe.getDateNaissance());
        return dto;
    }
}
