package com.example.javaspringbootexamproject.Controller;

import com.example.javaspringbootexamproject.Domain.Course;
import com.example.javaspringbootexamproject.Domain.Student;
import com.example.javaspringbootexamproject.Domain.University;
import com.example.javaspringbootexamproject.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/all")
    public List<Course>getAllCourses(){
        return courseRepository.findAll();
    }
    @PutMapping("/course/{id}")
    public Course updateCourse(@RequestBody Course updateCourse, @PathVariable Long id) {
        return courseRepository.findById(id).map(course -> {
                    course.setId(course.getId());
                    course.setName(course.getName());
                    return courseRepository.save(course);
                })
                .orElseGet(() -> {
                    updateCourse.setId(id);
                    return courseRepository.save(updateCourse);
                });

    }

    @PostMapping(value = "/addCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course newCourse(@RequestBody Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

}
