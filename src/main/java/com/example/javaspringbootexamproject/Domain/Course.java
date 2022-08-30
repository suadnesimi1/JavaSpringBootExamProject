package com.example.javaspringbootexamproject.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //provide the name of the field, which maps the relationship
    @ManyToMany(mappedBy = "courses")
    List<Student> students;


    public Course() {

    }

    @Autowired
    public Course(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
