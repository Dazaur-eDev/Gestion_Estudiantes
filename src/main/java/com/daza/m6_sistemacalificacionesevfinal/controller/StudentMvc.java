package com.daza.m6_sistemacalificacionesevfinal.controller;

import com.daza.m6_sistemacalificacionesevfinal.dto.student.StudentDto;
import com.daza.m6_sistemacalificacionesevfinal.service.student.StudentService;
import com.daza.m6_sistemacalificacionesevfinal.service.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentMvc {


    private final StudentService studentService;
    private final SubjectService subjectService;

    @GetMapping
    public String listOfStudents(Model model,
                                 @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam(required = false) String nameFilter,
                                 @RequestParam(required = false) String rutFilter
    ){
        Page<StudentDto> studentDto;

        if(nameFilter != null && !nameFilter.trim().isEmpty()){
            studentDto = studentService.findStudentByName(nameFilter, pageable);
        } else if (rutFilter != null && !rutFilter.trim().isEmpty()){
            studentDto = studentService.findStudentByRut(rutFilter, pageable);
        } else {
            studentDto = studentService.findAllStudents(pageable);
        }
        model.addAttribute("students", studentDto);
        model.addAttribute("totalPages", studentDto.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        return "students";
    }

}
