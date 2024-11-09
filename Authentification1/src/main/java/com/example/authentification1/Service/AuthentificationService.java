package com.example.authentification1.Service;

import com.example.authentification1.Controller.AuthentificationResponse;
import com.example.authentification1.Entity.Employe;

public interface AuthentificationService {
    public Employe registerEmployee(Employe employe);

    AuthentificationResponse login(String email, String password);
}
