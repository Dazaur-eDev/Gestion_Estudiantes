package com.daza.m6_sistemacalificacionesevfinal.mapper;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDtoSm;
import com.daza.m6_sistemacalificacionesevfinal.model.Student;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

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
        studentDto.setSubjects(student.getListOfSubjects().stream().map(subjectMapper::toDto).collect(Collectors.toSet()));
        return studentDto;
    }

    public Student toEntity(StudentCreateDto studentCreateDto) {
        if (studentCreateDto == null) {
            return null;
        }
        Student student = new Student();
        student.setRut(studentCreateDto.getRut());
        student.setName(studentCreateDto.getName());
        student.setDirection(studentCreateDto.getDirection());
        student.setEmail(studentCreateDto.getEmail());
        student.setListOfSubjects(new HashSet<>());
        return student;
    }

    public StudentDtoSm toDtoSm(Student student) {
        if (student == null) {
            return null;
        }
        StudentDtoSm studentDto = new StudentDtoSm();
        studentDto.setId(student.getId());
        studentDto.setRut(student.getRut());
        studentDto.setName(student.getName());
        studentDto.setDirection(student.getDirection());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }

}

