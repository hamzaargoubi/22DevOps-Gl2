package com.esprit.examen;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.entities.TypeSalle;
import com.esprit.examen.services.ISalleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceSalle {
    @Autowired
    public ISalleService salleService;


    @Test
    public void addSalle() {
        Salle salle = new Salle("25", TypeSalle.LABORATOIRE);
        assertThat(salle.getRef()).isNotNull();
        salleService.addSalle(salle);
    }

    @Test
    public void testListSalles() {
        List<Salle> salles =  salleService.listSalle();
        assertThat(salles).size().isPositive();
    }
}
