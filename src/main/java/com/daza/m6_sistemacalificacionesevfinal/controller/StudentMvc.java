package com.daza.m6_sistemacalificacionesevfinal.controller;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentUpdateDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import com.daza.m6_sistemacalificacionesevfinal.mapper.StudentMapper;
import com.daza.m6_sistemacalificacionesevfinal.service.student.StudentService;
import com.daza.m6_sistemacalificacionesevfinal.service.subject.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentMvc {

    private final StudentService studentService;
    private final SubjectService subjectService;
    private final StudentMapper studentMapper;

    @GetMapping()
    public String listOfStudents(Model model,
                                 @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam(required = false) String nameFilter,
                                 @RequestParam(required = false) String rutFilter
    ) {
        Page<StudentDto> studentDto;

        if (nameFilter != null && !nameFilter.trim().isEmpty()) {
            studentDto = studentService.findStudentByName(nameFilter, pageable);
        } else if (rutFilter != null && !rutFilter.trim().isEmpty()) {
            studentDto = studentService.findStudentByRut(rutFilter, pageable);
        } else {
            studentDto = studentService.findAllStudents(pageable);
        }
        model.addAttribute("students", studentDto);
        model.addAttribute("totalPages", studentDto.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("nameFilter", nameFilter);
        model.addAttribute("rutFilter", rutFilter);
        return "students";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {
        model.addAttribute("studentCreateDto", new StudentCreateDto());
        return "createStudent";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute StudentCreateDto studentCreateDto) {
        studentService.createStudent(studentCreateDto);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editarStudent(@PathVariable Long id,
                                Model model,
                                Pageable pageable) {
        StudentUpdateDto studentUpdateDto = studentService.searchStudentIdForUpdate(id);

        List<SubjectDto> allSubjects = subjectService.findAllSubjects(pageable).toList();
        List<SubjectDto> allSubjectsAvailableForStudent = allSubjects.stream()
                .filter(subject -> studentUpdateDto.getSubjects().stream()
                        .noneMatch(assigned -> assigned.getId().equals(subject.getId())))
                .toList();

        model.addAttribute("studentUpdateDto", studentUpdateDto);
        model.addAttribute("allSubjects", allSubjects);
        model.addAttribute("allSubjectsAvailableForStudent", allSubjectsAvailableForStudent);
        return "editStudent";
    }

    @PostMapping("/{id}/edit")
    public String editStudent(@PathVariable Long id,
                              @Valid @ModelAttribute StudentUpdateDto studentUpdateDto,
                              BindingResult bindingResult) {
        studentService.updateStudent(id, studentUpdateDto);
        return "redirect:/students";
    }
}