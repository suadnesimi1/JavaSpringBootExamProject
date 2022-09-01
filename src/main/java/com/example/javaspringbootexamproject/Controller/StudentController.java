package com.example.javaspringbootexamproject.Controller;

import com.example.javaspringbootexamproject.Domain.Student;
import com.example.javaspringbootexamproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;



    @GetMapping("/allStudentHTML")
    public String getStudentHTML(Model model){
        List<Student>studentList=studentRepository.findAll();
        model.addAttribute("students",studentList);
        return "studentList";
    }
    @GetMapping("all")
    public List<Student>getStudent(){
        return studentRepository.findAll();
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student updateStudent, @PathVariable int id) {
        return studentRepository.findById(id).map(student -> {
                    student.setId(student.getId());
                    student.setName(student.getName());
                    student.setCourses(student.getCourses());
                    student.setFaculty(student.getFaculty());
                    student.setUniversity(student.getUniversity());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    updateStudent.setId(id);
                    return studentRepository.save(updateStudent);
                });

    }

    @PostMapping(value = "/addStudent")
    public Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
    }
}
