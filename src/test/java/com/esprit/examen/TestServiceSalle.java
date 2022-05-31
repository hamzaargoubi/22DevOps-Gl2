package com.esprit.examen;

import com.esprit.examen.entities.Salle;
import com.esprit.examen.entities.TypeSalle;
import com.esprit.examen.services.ISalleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

@Slf4j
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
        log.info("salle ajouter avec succes");
    }

    @Test
    public void testListSalles() {
        List<Salle> salles = salleService.listSalle();
        log.info("list des salle");
        for (Salle salle : salles) {
            log.info(salle.toString());
        }
        log.info("fin list des salle");
        assertThat(salles).size().isPositive();
    }

    @Test
    public void getSalle() {
        Salle salle = salleService.getSalle(1L);
        log.info("Salle id : " + 1L);
        log.info(salle.toString());
        assertThat(salle).isNotNull();
    }

    @Test
    public void modifierSalle() {
        Salle salle = salleService.getSalle(1L);
        salle.setRef("azzz");
        salleService.modifierSalle(salle);
        assertEquals(salleService.getSalle(1L).getRef(), salle.getRef());
        log.info("salle " + salle.getId() + "modifier avec succes");
    }

    @Test
    public void supprimerSalle() {
        Salle salle = salleService.addSalle(new Salle("25", TypeSalle.LABORATOIRE));
        salleService.supprimerSalle(salle.getId());
        assertNull(salleService.getSalle(salle.getId()));
        log.warn("salle " + salle.getId() + " supprimer avec succes");
    }
}
