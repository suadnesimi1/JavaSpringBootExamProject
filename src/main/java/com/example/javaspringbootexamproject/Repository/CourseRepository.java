package com.example.javaspringbootexamproject.Repository;

import com.example.javaspringbootexamproject.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
