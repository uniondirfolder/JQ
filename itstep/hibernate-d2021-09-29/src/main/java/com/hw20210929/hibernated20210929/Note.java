package com.hw20210929.hibernated20210929;

import javafx.beans.property.SimpleStringProperty;


public class Note {

    private int id;
    private SimpleStringProperty date;
    private SimpleStringProperty body;

    public Note(int id, String date, String body) {
        this.date = new SimpleStringProperty(date);
        this.body = new SimpleStringProperty(body);
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        if (date != null) {
            return date.get();
        }
        return null;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getBody() {
        if(body!=null){
        return body.get();}
        return null;
    }

    public void setBody(String body) {
        this.body.set(body);
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public SimpleStringProperty bodyProperty() {
        return body;
    }

    public boolean isValid(){
        if(date!=null && body!=null && date.get()!=null && body.get()!=null && date.get().trim().length()!=0 && body.get().trim().length()!=0 ){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Note{" +
                "date='" + date.get() + '\'' +
                ", body='" + body.get() + '\'' +
                '}';
    }
}
