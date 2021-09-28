package com.hw20210929.hibernated20210929;

import com.hw20210929.hibernated20210929.utils.Transfer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CollectionNotes implements NotesBook {
    private ObservableList<Note> notes = FXCollections.observableArrayList();

    @Override
    public void create(Note note) {
        if (note != null && note.isValid()) {
            try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Dto.class)
                    .buildSessionFactory();
                 Session session = factory.getCurrentSession()

            ) {
                session.beginTransaction();
                Dto dto = Transfer.fromNote(note);
                session.save(dto);
                session.getTransaction().commit();
            }

        }
    }

    @Override
    public void update(Note note) {
        if (note != null && note.isValid()) {
            try (SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Dto.class)
                    .buildSessionFactory();
                 Session session = factory.getCurrentSession()

            ) {
                session.beginTransaction();
                Dto dto = Transfer.fromNote(note);
                session.update(dto);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public void delete(Note note) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dto.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()

        ) {
            session.beginTransaction();
            Dto dto = Transfer.fromNote(note);
            session.save(dto);
            session.getTransaction().commit();
            notes.remove(note);
        }
    }

    @Override
    public void read() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dto.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()

        ) {
            String str = "from Notes";
            session.beginTransaction();
            notes = (ObservableList<Note>) session.createQuery(str).getResultList();
            session.getTransaction().commit();
        }
    }

    public void printConsole() {
        notes.forEach(System.out::println);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }
}
