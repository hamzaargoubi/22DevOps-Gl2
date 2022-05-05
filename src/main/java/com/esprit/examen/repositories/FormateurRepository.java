package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;


@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	
    @Query("SELECT count(sc) FROM session_cours as sc INNER JOIN Cours as c on sc.cours_id = c.id" +
            " INNER JOIN Session as s on sc.session_id = s.id WHERE s.formateur is not null AND c.typeCours=:typeCours" +
            "  GROUP BY s.formateur")
	public Long nombreFormateursImpliquesDansUnCours(@Param("typeCours") TypeCours typeCours);
	

}
