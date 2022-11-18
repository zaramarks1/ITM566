package com.service;

import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.repository.StudentCourseRepository;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    public Student findStudentById(Integer id) throws SQLException {
        if(!studentRepository.existsStudentById(id)) throw new SQLException("Student not found");

        return studentRepository.findStudentById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }


    public List<Course> getStudentCourses(Integer id) throws SQLException{
        Student s = findStudentById(id);

        List<Course> courses = new ArrayList<>();

        for(StudentCourse sc: s.getStudentCourseList()) courses.add(sc.getCourse());

        return courses;
    }


}
