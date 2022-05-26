package com.esprit.examen.services;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImp implements ISalleService{
    @Autowired
    SalleRepository etudiantRepository;

    @Override
    public Long addSalle(Salle etudiant) {
        return etudiantRepository.save(etudiant).getId();
    }

    @Override
    public Long modifierSalle(Salle etudiant) {
        return etudiantRepository.save(etudiant).getId();
    }

    @Override
    public void supprimerSalle(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public List<Salle> listSalle() {
        return etudiantRepository.findAll();
    }
}
