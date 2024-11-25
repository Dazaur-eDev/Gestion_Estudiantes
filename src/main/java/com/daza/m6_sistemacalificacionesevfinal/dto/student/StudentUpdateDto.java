package com.daza.m6_sistemacalificacionesevfinal.dto.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectDto;
import com.daza.m6_sistemacalificacionesevfinal.validation.ValidRut;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDto {

    private Long id;

    @ValidRut()
    private String rut;

    @NotBlank(message = "A name is required")
    private String name;

    @NotBlank(message = "A direction is required")
    private String direction;

    @NotBlank(message = "An Email is mandatory")
    @Email(message = "Format of email not valid ")
    private String email;

    private Set<SubjectDto> subjects;
}
