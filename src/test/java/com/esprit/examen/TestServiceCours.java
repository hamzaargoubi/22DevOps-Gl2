package com.esprit.examen;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;

import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.services.ICoursService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceCours {

    @Autowired
    public ICoursService coursService;

    @Test
    public void addCours() {
        Cours cours = new Cours("cours", TypeCours.INFORMATIQUE,"intitulé");
    	cours.setDescription("cours1");
        assertThat(cours.getDescription()).isNotNull();
        coursService.addCours(cours);
    }

    @Test
    public void testListCourss() {
        List<Cours> courss =  coursService.getCours();
        assertThat(courss).size().isPositive();}
    public void testListCours() {
        List<Cours> courss =  coursService.getCours();
        assertThat(courss).size().isGreaterThan(0);
    }
    
    @Test
    public void testModifierCours() {
    	Cours cours = coursService.getCoursById(1L);
    	cours.setDescription("cours1");
    	coursService.modifierCours(cours);
    	assertTrue(cours.getDescription().equals("cours1"));
    }

    @Test
    public void testDeleteCours() {
    	Cours cours = coursService.getCours().get(0);
    	coursService.supprimerCours(cours.getId());
    	assertTrue(coursService.getCours().stream().filter(c->c.getId()==cours.getId()).collect(Collectors.toList()).size()==0);
    }
}
