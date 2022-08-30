package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

}
