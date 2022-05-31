package com.esprit.examen;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.services.IFormateurService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceFormateur {
    @Autowired
    public IFormateurService formateurService;


    @Test
    public void addFormateur() {
            Formateur formateur = new Formateur("nom", "prenom", Poste.INGENIEUR,
                    Contrat.CDI, "test@test.com", "password");
            assertNotNull(formateurService.addFormateur(formateur));
            log.info("success");
        }

    @Test
    public void testListFormateurs() {
        List<Formateur> formateurs =  formateurService.listFormateurs();
        assertThat(formateurs).size().isPositive();
    }

    @Test
    public void testUpdateFormateur(){
        Formateur formateur =  formateurService.getFormateurById(2L);
        formateur.setEmail("aaa@gmail.com");
        formateurService.modifierFormateur(formateur);
        assertEquals("aaa@gmail.com",formateurService.getFormateurById(2L).getEmail());
    }

    @Test
    public void testDeleteFormateur(){
        Formateur formateur = formateurService.listFormateurs().get(0);
        formateurService.supprimerFormateur(formateur.getId());
        assertEquals(0,formateurService.listFormateurs()
                .stream().filter(f->f.getId()==formateur.getId()).collect(Collectors.toList()).size());
    }

    }



