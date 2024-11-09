package com.example.authentification1.Repos;

import com.example.authentification1.Entity.Employe;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepo extends CrudRepository<Employe , Long> {
    Employe findByCin (long cin);
}
