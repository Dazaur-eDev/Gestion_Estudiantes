package com.daza.m6_sistemacalificacionesevfinal.service.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Page<StudentDto> findAllStudents(Pageable pageable);
    StudentDto createStudent(StudentCreateDto studentCreateDto);

    StudentDtoSm updateStudent(Long id, StudentDtoSm studentUpdateDtoSm);
    StudentDto updateStudent(Long id, StudentUpdateDto studentUpdateDto);
    void deleteStudent(Long id);
    Page<StudentDto> findStudentByName(String name, Pageable pageable);
    Page<StudentDto> findStudentByRut(String rut, Pageable pageable);

    Page<StudentDtoSm> findAllStudentsSm(Pageable pageable);
    StudentDto searchStudentId(Long id);
    StudentUpdateDto searchStudentIdForUpdate(Long id);
}
