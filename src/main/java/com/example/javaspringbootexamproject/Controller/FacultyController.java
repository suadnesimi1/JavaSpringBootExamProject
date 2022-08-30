package com.example.javaspringbootexamproject.Controller;


import com.example.javaspringbootexamproject.Domain.Course;
import com.example.javaspringbootexamproject.Domain.Faculty;
import com.example.javaspringbootexamproject.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyRepository facultyRepository;
    FacultyController(){

    }

    @GetMapping("/all")
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }


    @PutMapping("/faculty/{id}")
    public Faculty updateFaculty(@RequestBody Faculty updateFaculty, @PathVariable Long id) {
        return facultyRepository.findById(id).map(faculty -> {
                    faculty.setId(faculty.getId());
                    faculty.setName(faculty.getName());
                    return facultyRepository.save(faculty);
                })
                .orElseGet(() -> {
                    updateFaculty.setId(id);
                    return facultyRepository.save(updateFaculty);
                });

    }

    @PostMapping(value = "/addFaculty", produces = MediaType.APPLICATION_JSON_VALUE)
    public Faculty newFaculty(@RequestBody Faculty newFaculty) {
        return facultyRepository.save(newFaculty);
    }

    @DeleteMapping("/faculty/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
    }
}
