package com.esprit.examen;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Etudiant;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.services.IEtudiantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.*;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertThat(etudiant.getBirthday()).isNotNull();
        etudiantService.addEtudiant(etudiant);
    }

    @Test
    public void testListEtudiants() {
        List<Etudiant> etudiants =  etudiantService.listEtudiant();
        assertThat(etudiants).size().isPositive();
    }
    @Test
    public void testUpdateEtudiant(){
        Etudiant etudiant =  etudiantService.trouverEtudiantParId(1L);
        etudiant.setName("test");
        etudiantService.modifierEtudiant(etudiant);
        assertEquals("test",etudiantService.trouverEtudiantParId(1L).getName());
    }
}
