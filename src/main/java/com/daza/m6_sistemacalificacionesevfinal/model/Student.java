package com.daza.m6_sistemacalificacionesevfinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "rut", unique = true, length = 12, nullable = false)
    private String rut;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "direction", length = 60, nullable = false)
    private String direction;

    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "Student_Subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> listOfSubjects = new HashSet<>();

}

