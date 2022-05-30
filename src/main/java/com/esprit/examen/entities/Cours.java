package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Enumerated(EnumType.STRING)
	private TypeCours typeCours;
	private String intitule;
	@ManyToMany(mappedBy="cours")
	private Set<Session> sessions;
	@ManyToMany

	private transient List<Etudiant> etudiants;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TypeCours getTypeCours() {
		return typeCours;
	}
	public void setTypeCours(TypeCours typeCours) {
		this.typeCours = typeCours;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Cours{" +
				"id=" + id +
				", description='" + description + '\'' +
				", typeCours=" + typeCours +
				", intitule='" + intitule + '\'' +
				", sessions=" + sessions +
				", etudiants=" + etudiants +
				'}';
	}

	public Cours( String description, TypeCours typeCours, String intitule) {
		super();
		this.description = description;
		this.typeCours = typeCours;
		this.intitule = intitule;
	}
	public Cours() {
		super();
	}
	
	
}
