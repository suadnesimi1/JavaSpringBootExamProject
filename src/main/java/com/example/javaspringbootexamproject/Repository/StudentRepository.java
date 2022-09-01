package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    }

