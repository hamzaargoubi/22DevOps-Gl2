package com.esprit.examen.services;

import com.esprit.examen.entities.Planning;

import java.util.List;

public interface IPlanningService {
    Long addPlanning(Planning planning);

    Long modifierPlanning(Planning planning);

    void supprimerPlanning(Long planningId);

    List<Planning> listPlanning();
}
