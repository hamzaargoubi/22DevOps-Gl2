package com.esprit.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;

import java.util.List;

@Service
public class SessionService implements ISessionService{

	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Session addSession(Session session) {
		session = sessionRepository.save(session);
		return session;
	}

	@Override
	public Session modifierSession(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public void supprimerSession(Long sessionId) {
		sessionRepository.deleteById(sessionId);
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
		//a bullshit method
	}

	@Override
	public List<Session> listSessions() {
		return sessionRepository.findAll();
	}

}
