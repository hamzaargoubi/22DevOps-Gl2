package com.esprit.examen.services;

import com.esprit.examen.entities.Etudiant;


import java.util.List;


public interface IEtudiantService {
    Long addEtudiant(Etudiant etudiant);

    Long modifierEtudiant(Etudiant etudiant);

    void supprimerEtudiant(Long etudiantId);

    List<Etudiant> listEtudiant();
    Etudiant getOne(Long id);
}
