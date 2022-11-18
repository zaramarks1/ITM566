package com.repository;

import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, String>, JpaSpecificationExecutor<StudentCourse> {


    List<Course> findCourseByStudent(Student student);
}
