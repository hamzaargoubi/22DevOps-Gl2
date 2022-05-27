package com.esprit.examen.controllers;

import com.esprit.examen.entities.Etudiant;
import com.esprit.examen.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantServiceImp;

    @PostMapping("/ajouterEtudiant")
    @ResponseBody
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        etudiantServiceImp.addEtudiant(etudiant);
        return etudiant;
    }

    @PutMapping("/modifierEtudiant")
    @ResponseBody
    public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
        etudiantServiceImp.modifierEtudiant(etudiant);
        return etudiant;
    }

    @DeleteMapping("/supprimerEtudiant/{etudiantId}")
    @ResponseBody
    public void supprimerEtudiant(@PathVariable("etudiantId") Long etudiantId) {
        etudiantServiceImp.supprimerEtudiant(etudiantId);
    }
}
