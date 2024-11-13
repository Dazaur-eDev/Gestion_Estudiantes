package com.daza.m6_sistemacalificacionesevfinal.controller;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<Page<StudentDto>> findAll(Pageable pageable) {
        Page<StudentDto> studentsDto = studentService.findAllStudents(pageable);
        return ResponseEntity.ok(studentsDto);  //200 OK with the list of students
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentCreateDto studentCreateDto) {
        StudentDto studentDto = studentService.createStudent(studentCreateDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(studentDto); // 201 Created new student with Location
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @Valid @RequestBody StudentCreateDto studentCreateDto) {
        StudentDto updatedStudent = studentService.updateStudent(id, studentCreateDto);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent); // 200 OK with the updated student
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found if student do not exist
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
