package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
