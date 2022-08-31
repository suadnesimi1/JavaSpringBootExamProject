package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
}
