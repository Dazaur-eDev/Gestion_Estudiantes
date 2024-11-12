package com.daza.m6_sistemacalificacionesevfinal.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String Path;
    private int status;

}
