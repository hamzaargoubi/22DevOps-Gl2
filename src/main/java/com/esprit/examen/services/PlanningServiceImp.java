package com.esprit.examen.services;

import com.esprit.examen.entities.Planning;
import com.esprit.examen.repositories.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningServiceImp implements IPlanningService{

    @Autowired
    PlanningRepository planningRepository;

    @Override
    public Long addPlanning(Planning planning) {
        return planningRepository.save(planning).getId();
    }

    @Override
    public Long modifierPlanning(Planning planning) {
        return planningRepository.save(planning).getId();
    }

    @Override
    public void supprimerPlanning(Long planningId) {
        planningRepository.deleteById(planningId);
    }

    @Override
    public List<Planning> listPlanning() {
        return planningRepository.findAll();
    }
}
