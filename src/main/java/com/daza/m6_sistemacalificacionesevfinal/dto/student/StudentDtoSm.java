package com.daza.m6_sistemacalificacionesevfinal.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoSm {
    private Long id;
    private String rut;
    private String name;
    private String direction;
    private String email;
}
