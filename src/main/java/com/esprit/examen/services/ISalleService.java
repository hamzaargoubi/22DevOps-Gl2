package com.esprit.examen.services;

import com.esprit.examen.entities.Salle;

import java.util.List;

public interface ISalleService {
    Salle addSalle(Salle salle);

    Long modifierSalle(Salle salle);

    void supprimerSalle(Long salleId);

    List<Salle> listSalle();

    Salle getSalle(Long id);
}
