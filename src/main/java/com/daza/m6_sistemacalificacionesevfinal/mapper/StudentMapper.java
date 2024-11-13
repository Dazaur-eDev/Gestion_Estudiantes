package com.daza.m6_sistemacalificacionesevfinal.mapper;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import org.springframework.stereotype.Component;

import java.util.HashSet;

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
        return student;
    }
}

