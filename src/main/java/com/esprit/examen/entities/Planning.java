package com.esprit.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Planning implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String relatedClass;

    @ManyToMany
    private List<Session> sessions;

    public Planning() {
    }

    public Planning(int year,String relatedClass) {
        this.year = year;
        this.relatedClass = relatedClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int yeaar) {
        this.year = yeaar;
    }
    public String getRelatedClass() {
        return relatedClass;
    }

    public void setRelatedClass(String relatedClass) {
        this.relatedClass = relatedClass;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "id=" + id +
                ", year=" + year +
                ", relatedClass='" + relatedClass + '\'' +
                ", sessions=" + sessions +
                '}';
    }
}
