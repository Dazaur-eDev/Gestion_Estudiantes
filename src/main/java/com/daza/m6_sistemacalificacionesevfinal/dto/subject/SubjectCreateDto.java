package com.daza.m6_sistemacalificacionesevfinal.dto.subject;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateDto {

    @NotBlank(message = "El nombre de la materia es obligatorio")
    private String name;

}
