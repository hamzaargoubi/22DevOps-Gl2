package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;

public interface IFormateurService {
	Formateur addFormateur(Formateur formateur);

	Formateur modifierFormateur(Formateur formateur);

	void supprimerFormateur(Long formateurId);

	Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours);

	Formateur getFormateurById(Long id);
		
	List<Formateur> listFormateurs();
}
