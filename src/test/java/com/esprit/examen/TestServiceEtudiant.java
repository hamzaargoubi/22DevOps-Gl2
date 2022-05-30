package com.esprit.examen;

import com.esprit.examen.entities.Etudiant;
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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

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
    }

    @Test
    public void testListEtudiants() {
        List<Etudiant> etudiants =  etudiantService.listEtudiant();
        assertThat(etudiants).size().isGreaterThan(0);
    }

    @Test
    public void modifierEtudiant() throws ParseException{
        Etudiant etudiant =etudiantService.getOne(1L);
        etudiant.setName("abdou");
        etudiantService.modifierEtudiant(etudiant);
        assertTrue(etudiantService.getOne(1L).getName().equals("abdou"));
    }

    @Test
    public void supprimer() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        Long etudiantId = etudiantService.addEtudiant(new Etudiant("etudiant",date));
        etudiantService.supprimerEtudiant(etudiantId);
        assertNull(etudiantService.getOne(etudiantId));
    }

    @Test
    public void getOne(){
       Etudiant e= etudiantService.getOne(1L);
        assertThat(e).isNotNull();
    }
}
