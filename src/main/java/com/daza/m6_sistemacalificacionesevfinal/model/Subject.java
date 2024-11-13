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
@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subjects_id")
    private Long id;

    @Column(name = "name", unique = true, length = 30, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "listOfSubjects")
    private Set<Student> student = new HashSet<>();
}
