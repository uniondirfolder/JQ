package com.hw20210929.hibernated20210929;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Dto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "disc")
    private String disc;

    public Dto() {
    }

    public Dto(int id, String date, String disc) {
        this.id = id;
        this.date = date;
        this.disc = disc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
