package com.esprit.examen.controllers;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalleRestController {
    @Autowired
    ISalleService salleServiceImp;

    @PostMapping("/ajouterSalle")
    @ResponseBody
    public Salle ajouterSalle(@RequestBody Salle salle) {
        salleServiceImp.addSalle(salle);
        return salle;
    }

    @PutMapping("/modifierSalle")
    @ResponseBody
    public Salle modifierSalle(@RequestBody Salle salle) {
        salleServiceImp.modifierSalle(salle);
        return salle;
    }

    @DeleteMapping("/supprimerSalle/{salleId}")
    @ResponseBody
    public void supprimerSalle(@PathVariable("salleId") Long salleId) {
        salleServiceImp.supprimerSalle(salleId);
    }
}
