package com.esprit.examen;

import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;
import com.esprit.examen.services.ISessionService;
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
public class TestServiceSession {
    @Autowired
    public ISessionService sesionService;
    @Autowired
    public SessionRepository sessionRepository;


    @Test
    public void addSession() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = dateFormat.parse("2022-03-22");
        Date dateFin = dateFormat.parse("2022-03-23");
        Session sesion = new Session(dateDebut,dateFin, 2l,"c'est une session pour le cours de devops");
        assertThat(sesion.getDescription()).isNotNull();
        sesionService.addSession(sesion);
    }

    @Test
    public void testListSessions() {
        List<Session> sesions =  sesionService.listSessions();
        assertThat(sesions).size().isPositive();
    }
    @Test
    public void testmodifierSession() {
        Session s =sessionRepository.findById(1l).get();
        s.setDuree(300l);
        Session session=sesionService.modifierSession(s);
        assertThat(session.getDuree()).isEqualTo(300l);
    }

    @Test
    public void testSupprimerSession(){

        sesionService.supprimerSession(1L);
        List<Session> sessions =  sesionService.listSessions();
        for (Session s : sessions){
            assertThat(s.getId()).isNotEqualTo(1L);
        }

    }
}
