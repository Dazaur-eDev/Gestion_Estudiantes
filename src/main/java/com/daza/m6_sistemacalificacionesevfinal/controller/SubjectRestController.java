package com.daza.m6_sistemacalificacionesevfinal.controller;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import com.daza.m6_sistemacalificacionesevfinal.service.subject.SubjectService;
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
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectRestController {

    private final SubjectService subjectService;

    @GetMapping("/list")
    public ResponseEntity<Page<SubjectDto>> findAll(Pageable pageable) {
        Page<SubjectDto> subjectsDto = subjectService.findAllSubjects(pageable);
        return ResponseEntity.ok(subjectsDto);  //200 OK with the list of students
    }

    @PostMapping("/create")
    public ResponseEntity<SubjectDto> create(@Valid @RequestBody SubjectCreateDto subjectCreateDto) {
        SubjectDto subjectsDto = subjectService.createSubject(subjectCreateDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(subjectsDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(subjectsDto); // 201 Created new student with Location
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable Long id, @Valid @RequestBody SubjectCreateDto subjectCreateDto) {
        SubjectDto updatedSubject = subjectService.updateSubject(id, subjectCreateDto);
        if (updatedSubject != null) {
            return ResponseEntity.ok(updatedSubject); // 200 OK with the updated student
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found if student do not exist
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
