package com.esprit.examen;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.services.IFormateurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceFormateur {
    private static final Logger l = LogManager.getLogger(TestServiceFormateur.class);
    @Autowired
    public IFormateurService formateurService;


    @Test
    public void addFormateur() {
            Formateur formateur = new Formateur("nom", "prenom", Poste.Ingénieur,
                    Contrat.CDI, "test@test.com", "password");
            assertTrue(formateur.getContrat().equals(Contrat.CDI));
            formateurService.addFormateur(formateur);
        }

    @Test
    public void testListFormateurs() {
        List<Formateur> formateurs =  formateurService.listFormateurs();
        assertThat(formateurs).size().isGreaterThan(0);
    }

    }



