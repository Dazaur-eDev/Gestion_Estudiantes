package com.daza.m6_sistemacalificacionesevfinal.service.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDtoSm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    //Para Mvc
    Page<StudentDto> findAllStudents(Pageable pageable);
    StudentDto createStudent(StudentCreateDto studentCreateDto);
    StudentDto updateStudent(Long id, StudentCreateDto studentCreateDto);
    void deleteStudent(Long id);
    Page<StudentDto> findStudentByName(String name, Pageable pageable);
    Page<StudentDto> findStudentByRut(String rut, Pageable pageable);
    //Para Rest
    Page<StudentDtoSm> findAllStudentsSm(Pageable pageable);
}
