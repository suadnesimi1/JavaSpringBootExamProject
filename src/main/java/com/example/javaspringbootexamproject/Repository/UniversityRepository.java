package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
