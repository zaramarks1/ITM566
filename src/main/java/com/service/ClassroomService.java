package com.service;

import com.entity.Classroom;
import com.entity.Course;
import com.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Course> getCourses(Integer id){
        Classroom classroom = classroomRepository.findClassroomById(id);

        return classroom.getCourses();
    }


}
