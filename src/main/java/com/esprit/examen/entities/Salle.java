package com.esprit.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private TypeSalle typeSalle;

    @OneToMany(mappedBy = "salle")
    private List<Session> sessions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public TypeSalle getTypeSalle() {
        return typeSalle;
    }

    public void setTypeSalle(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Salle(String ref, TypeSalle typeSalle) {
        this.ref = ref;
        this.typeSalle = typeSalle;
    }

    public Salle() {
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", typeSalle=" + typeSalle +
                '}';
    }
}
