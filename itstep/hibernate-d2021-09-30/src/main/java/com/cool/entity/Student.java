package com.cool.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "tax_number")
    private String taxNumber;
    @Column(name = "country")
    private String country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses"
            , joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Course> courses;

    public Student() {
    }

    public Student(String name, String surname, String taxNumber, String country) {
        this.name = name;
        this.surname = surname;
        this.taxNumber = taxNumber;
        this.country = country;
    }

    public void addCourseToStudent(Course course) {
        if(courses==null){
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", country='" + country + '\'' +
                ", courses=" + courses +
                '}';
    }
}
