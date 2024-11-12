package com.daza.m6_sistemacalificacionesevfinal.dto.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String rut;
    private String name;
    private String direction;
    private String email;
}
