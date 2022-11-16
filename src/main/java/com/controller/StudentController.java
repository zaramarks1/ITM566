package com.controller;

import com.entity.Student;
import com.repository.StudentRepository;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("")
    private ResponseEntity<List<Student>> getAll(){

        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Student> getById(@PathVariable("id") Integer id) throws SQLException {

        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @PostMapping("")
    private ResponseEntity<Student> addStudent(@RequestBody Student student){
            return null;
    }


}
