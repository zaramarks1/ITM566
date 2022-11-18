package com.repository;


import com.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String>, JpaSpecificationExecutor<Classroom> {

    Classroom findClassroomById(Integer id);
}
