package com.daza.m6_sistemacalificacionesevfinal.dto.student;

import com.daza.m6_sistemacalificacionesevfinal.dto.subject.SubjectCreateDto;
import com.daza.m6_sistemacalificacionesevfinal.validation.ValidRut;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDto {
    @ValidRut()
    private String rut;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "La dirección es requerida")
    private String direction;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato de email no es valido")
    private String email;
}

//record StudentCreate (String rut, String name, String direction, Set<SubjectCreateDto> list){}
