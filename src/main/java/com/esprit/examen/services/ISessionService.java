package com.esprit.examen.services;

import com.esprit.examen.entities.Session;

import java.util.List;

public interface ISessionService {
	Session addSession(Session session);

	Session modifierSession(Session session);

	void supprimerSession(Long sessionId);
	
	void affecterFormateurASession (Long formateurId, Long sessionId);
	List<Session> listSessions();
}
