package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    List<Student>findStudentsByName(String name,Pageable pageable,String sortBy);
}
