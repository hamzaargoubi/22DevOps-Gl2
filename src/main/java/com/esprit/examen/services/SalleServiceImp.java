package com.esprit.examen.services;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImp implements ISalleService{
    @Autowired
    SalleRepository salleRepository;

    @Override
    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public Long modifierSalle(Salle salle) {
        return salleRepository.save(salle).getId();
    }

    @Override
    public void supprimerSalle(Long salletId) {
        salleRepository.deleteById(salletId);
    }

    @Override
    public List<Salle> listSalle() {
        return salleRepository.findAll();
    }

    @Override
    public Salle getSalle(Long id) {
        return salleRepository.findById(id).orElse(null);
    }
}
