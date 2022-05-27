package com.esprit.examen;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.ICoursService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceCours {

    @Autowired
    public ICoursService coursService;

    @Test
    public void addCours() {
        Cours cours = new Cours("cours", TypeCours.SCRUM,"intitulé");
        assertThat(cours.getDescription()).isNotNull();
        coursService.addCours(cours);
    }

    @Test
    public void testListCourss() {
        List<Cours> courss =  coursService.getCours();
        assertThat(courss).size().isPositive();
    }
}
