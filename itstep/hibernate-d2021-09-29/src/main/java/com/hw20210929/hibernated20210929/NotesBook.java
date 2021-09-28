package com.hw20210929.hibernated20210929;

import javafx.collections.ObservableList;

public interface NotesBook {
    void create(Note note);
    void update(Note note);
    void delete(Note note);
    void read();
}
