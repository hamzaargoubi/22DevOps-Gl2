package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.config.LoggingAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

@Service
public class FormateurService implements IFormateurService{
	@Autowired
	FormateurRepository formateurRepository;
	@Override
	public Formateur addFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur;
	}

	@Override
	public Formateur modifierFormateur(Formateur formateur) {
		return formateurRepository.save(formateur);
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		formateurRepository.deleteById(formateurId);
		
	}

	@Override
	public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
		return formateurRepository.nombreFormateursImpliquesDansUnCours(typeCours);
	}

	@Override
	public Formateur getFormateurById(Long id) {
		return formateurRepository.findById(id).orElse(null);
	}


	@Override
	public List<Formateur> listFormateurs() {
		
		return formateurRepository.findAll();
	}


	
	

}
