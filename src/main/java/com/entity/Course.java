package com.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "numberId", nullable = false)
    private Integer numberId;

    @ManyToOne
    @JoinColumn(name = "classroomId")
    private Classroom classroom;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourseList = new ArrayList<>();




}
