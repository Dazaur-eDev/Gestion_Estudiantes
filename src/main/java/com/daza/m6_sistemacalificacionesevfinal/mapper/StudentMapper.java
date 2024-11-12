package com.daza.m6_sistemacalificacionesevfinal.mapper;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;

import com.daza.m6_sistemacalificacionesevfinal.model.Student;

import org.springframework.stereotype.Component;


import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;

@Component
public class StudentMapper {

    private final SubjectMapper subjectMapper;

    public StudentMapper(@Lazy SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    public StudentDto toDto(Student student) {
        if (student == null) {
            return null;
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setRut(student.getRut());
        studentDto.setName(student.getName());
        studentDto.setDirection(student.getDirection());
        studentDto.setEmail(student.getEmail());

//        if (student.getListOfSubjects() != null) {
//            studentDto.setListOfSubjects(student.getListOfSubjects().stream()
//                    .map(subjectMapper::toDto)
//                    .collect(Collectors.toSet()));
//        }

        return studentDto;
    }

    public Student toEntity(StudentCreateDto studentCreateDto) {
        if (studentCreateDto == null) {
            return null;
        }

        System.out.println("Mapping StudentCreateDto to Student entity: " + studentCreateDto);
        Student student = new Student();
        student.setRut(studentCreateDto.getRut());
        student.setName(studentCreateDto.getName());
        student.setDirection(studentCreateDto.getDirection());
        student.setEmail(studentCreateDto.getEmail());
        student.setListOfSubjects(new HashSet<>());

//        if (studentCreateDto.getListOfSubjects() != null) {
//            student.setListOfSubjects(studentCreateDto.getListOfSubjects().stream()
//                    .map(subjectMapper::toEntity)
//                    .collect(Collectors.toSet()));
//        }
        return student;
    }
}

