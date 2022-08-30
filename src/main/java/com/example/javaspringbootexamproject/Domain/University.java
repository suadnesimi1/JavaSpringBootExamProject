package com.example.javaspringbootexamproject.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Faculty> faculty;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;


    public University() {

    }

    @Autowired
    public University(Long id, String name, List<Faculty> faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
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
