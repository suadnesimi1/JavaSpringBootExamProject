package com.example.javaspringbootexamproject.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;


    public Faculty() {

    }

    @Autowired
    public Faculty(Long id, String name, University university) {
        this.id = id;
        this.name = name;
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
