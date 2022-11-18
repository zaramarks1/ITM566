package com.controller;

import com.entity.Classroom;
import com.entity.Course;
import com.repository.ClassroomRepository;
import com.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/{id}/courses")
    private ResponseEntity<List<Course>> getCourses(@PathVariable("id") Integer id){
        return ResponseEntity.ok(classroomService.getCourses(id));
    }

    @GetMapping("")
    private ResponseEntity<List<Classroom>> getAllClassRooms(){
        return ResponseEntity.ok(classroomRepository.findAll());
    }
}
