package com.esprit.examen;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.entities.TypeSalle;
import com.esprit.examen.services.ISalleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceSalle {
    @Autowired
    public ISalleService salleService;
    
    @Test
    public void addSalle() {
        Salle salle = new Salle("25", TypeSalle.LABORATOIRE);
        salleService.addSalle(salle);
        assertThat(salle.getId()).isNotNull();
    }

    @Test
    public void testListSalles() {
        List<Salle> salles = salleService.listSalle();
        assertThat(salles).size().isPositive();
    }

    @Test
    public void getSalle() {
        Salle s = salleService.getSalle(1L);
        assertThat(s).isNotNull();
    }

    @Test
    public void modifierSalle() {
        Salle salle = salleService.getSalle(1L);
        salle.setRef("azzz");
        salleService.modifierSalle(salle);
        assertEquals(salleService.getSalle(1L).getRef(), salle.getRef());
    }

    @Test
    public void supprimerSalle() {
        Salle salle = salleService.addSalle(new Salle("25", TypeSalle.LABORATOIRE));
        salleService.supprimerSalle(salle.getId());
        assertNull(salleService.getSalle(salle.getId()));
    }
}
