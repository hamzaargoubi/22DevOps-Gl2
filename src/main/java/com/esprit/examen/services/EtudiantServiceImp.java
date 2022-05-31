package com.esprit.examen.services;

import com.esprit.examen.entities.Etudiant;
import com.esprit.examen.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Long addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant).getId();
    }

    @Override
    public Long modifierEtudiant(Etudiant etudiant) {

         etudiantRepository.save(etudiant);
                return etudiant.getId();
    }

    @Override
    public void supprimerEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public List<Etudiant> listEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getOne(Long id) {
        return etudiantRepository.findById(id).orElse(null);

    }
}
