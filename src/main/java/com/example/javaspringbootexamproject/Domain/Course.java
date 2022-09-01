package com.example.javaspringbootexamproject.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    //provide the name of the field, which maps the relationship
    @ManyToMany(mappedBy = "courses")
    List<Student> students;


    public Course() {

    }

    @Autowired
    public Course(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;

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
}
