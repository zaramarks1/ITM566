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
@Table
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
