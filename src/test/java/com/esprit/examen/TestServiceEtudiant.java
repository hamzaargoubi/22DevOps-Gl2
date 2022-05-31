package com.esprit.examen;

import com.esprit.examen.entities.Etudiant;
import com.esprit.examen.entities.Salle;
import com.esprit.examen.services.IEtudiantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceEtudiant {
    @Autowired
    public IEtudiantService etudiantService;


    @Test
    public void addEtudiant() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        Etudiant etudiant = new Etudiant("etudiant",date);
        etudiantService.modifierEtudiant(etudiant);
        assertThat(etudiant.getBirthday()).isNotNull();
        assertThat(etudiant.getName()).isNotNull();
        assertThat(etudiant.getId()).isNotNull();
        log.info("Etudiant ajouter avec succes");
    }

    @Test
    public void testListEtudiants() {
        List<Etudiant> etudiants =  etudiantService.listEtudiant();
        log.info("list des etudiants");
        for (Etudiant e : etudiants) {
            log.info(e.toString());
        }
        log.info("fin list des etudiants");
        assertThat(etudiants).size().isGreaterThan(0);
    }

    @Test
    public void modifierEtudiant() throws ParseException{
        Etudiant etudiant =etudiantService.getOne(1L);
        etudiant.setName("abdou");
        etudiantService.modifierEtudiant(etudiant);
        assertTrue(etudiantService.getOne(1L).getName().equals("abdou"));
        log.info("Etudiant " + etudiant.getId() + "modifier avec succes");

    }

    @Test
    public void supprimer() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        Long etudiantId = etudiantService.addEtudiant(new Etudiant("etudiant",date));
        etudiantService.supprimerEtudiant(etudiantId);
        assertNull(etudiantService.getOne(etudiantId));
        log.warn("Etudiant " + etudiantId+ " supprimer avec succes");

    }

    @Test
    public void getOne(){
       Etudiant e= etudiantService.getOne(1L);
        log.info("Etudiant id : " + 1L);
        log.info(e.toString());
        assertThat(e).isNotNull();
    }
}
