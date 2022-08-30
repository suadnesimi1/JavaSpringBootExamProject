package com.example.javaspringbootexamproject.Controller;


import com.example.javaspringbootexamproject.Domain.Faculty;
import com.example.javaspringbootexamproject.Domain.University;
import com.example.javaspringbootexamproject.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    UniversityRepository universityRepository;

    @GetMapping("/all")
    public List<University>getAllUniversities(){
        return universityRepository.findAll();
    }
    @PostMapping(value = "/addUniversity", produces = MediaType.APPLICATION_JSON_VALUE)
    public University newUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }
}
