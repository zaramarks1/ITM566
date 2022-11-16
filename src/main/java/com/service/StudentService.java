package com.service;

import com.entity.Student;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student findStudentById(Integer id) throws SQLException {
        if(!studentRepository.existsById(id.toString())) throw new SQLException("Student not found");

        return studentRepository.findStudentById(id);
    }
}
