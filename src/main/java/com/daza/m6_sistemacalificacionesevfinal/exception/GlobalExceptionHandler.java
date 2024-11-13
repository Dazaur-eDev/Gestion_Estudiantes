package com.daza.m6_sistemacalificacionesevfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Student Not Found");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("path", request.getDescription(false));

        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
        /* Mensaje de salida por Api
        "type": "about:blank",
        "title": "Student Not Found",
        "status": 404,
        "detail": "Student with id 99 not found",
        "instance": "/api/v1/students/99",
        "timestamp": "2024-11-12T23:14:13.5849118",
        "path": "uri=/api/v1/students/99",
        "description": "Student with id 99 not found"
        */
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleSubjectNotFoundException(SubjectNotFoundException ex, WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Subject Not Found");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("path", request.getDescription(false));

        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
        /* Mensaje de salida por Api
        "type": "about:blank",
        "title": "Subject Not Found",
        "status": 404,
        "detail": "Subject with id 7 not found",
        "instance": "/api/v1/subjects/7",
        "timestamp": "2024-11-13T01:00:24.5574489",
        "path": "uri=/api/v1/subjects/7"
        */
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ProblemDetail> handlePSQLException(PSQLException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

        //Si RUT ya existe

        /*Mensaje de salida por Api
            "type": "about:blank",
            "title": "LLave duplicada",
            "status": 400,
            "detail": "El RUT ya está registrado: 13345678-9",
            "instance": "/api/v1/students/create",
            "timestamp": "2024-11-13T00:22:32.2309867",
            "path": "uri=/api/v1/students/create"
         */
        if (ex.getMessage().contains("El RUT ya está registrado: ")) {
            problemDetail.setTitle("LLave duplicada");
            problemDetail.setProperty("timestamp", LocalDateTime.now());
            problemDetail.setProperty("path", request.getDescription(false));
            return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
        }

        //Si nombre asignatura ya existe

        /*Mensaje de salida por Api
            "type": "about:blank",
            "title": "LLave duplicada",
            "status": 400,
            "detail": "La asignatura ya existe: Matemáticas2",
            "instance": "/api/v1/subjects/create",
            "timestamp": "2024-11-13T01:06:05.1608771",
            "path": "uri=/api/v1/subjects/create"
        */
        if (ex.getMessage().contains("La asignatura ya existe: ")) {
            problemDetail.setTitle("LLave duplicada");
            problemDetail.setProperty("timestamp", LocalDateTime.now());
            problemDetail.setProperty("path", request.getDescription(false));
            return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
        }

        //Puedo agregar otras condiciones de acuerdo al caso de errores con la bd
        return null;
    }
}
