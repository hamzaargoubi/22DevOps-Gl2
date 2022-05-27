package com.esprit.examen.controllers;

import com.esprit.examen.entities.Planning;
import com.esprit.examen.services.IPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanningRestController {
    @Autowired
    IPlanningService planningServiceImp;

    @PostMapping("/ajouterPlanning")
    @ResponseBody
    public Planning ajouterPlanning(@RequestBody Planning planning) {
        planningServiceImp.addPlanning(planning);
        return planning;
    }

    @PutMapping("/modifierPlanning")
    @ResponseBody
    public Planning modifierPlanning(@RequestBody Planning planning) {
        planningServiceImp.modifierPlanning(planning);
        return planning;
    }

    @DeleteMapping("/supprimerPlanning/{planningId}")
    @ResponseBody
    public void supprimerPlanning(@PathVariable("planningId") Long planningId) {
        planningServiceImp.supprimerPlanning(planningId);
    }
}
