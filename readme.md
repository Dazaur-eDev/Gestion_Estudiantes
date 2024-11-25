# Sistema de Calificaciones - Universidad de Los Andes

Este proyecto consiste en desarrollar un sistema de calificaciones para la Universidad de Los Andes, diseñado para gestionar datos de alumnos y las materias asignadas. El sistema incluye un backend RESTful API con autenticación JWT y un frontend para la visualización y gestión de datos.

## Funcionalidades
1. **Gestión de Alumnos**:
  - Creación y consulta de alumnos.
  - Registro de materias asociadas a cada alumno.
2. **Autenticación JWT**:
  - Inicio de sesión con token JWT para seguridad.
3. **Interfaz Web**:
  - Login de usuario con validación mediante REST API.
  - Visualización de alumnos y sus materias en una vista estática.

---

## Requisitos
### Tecnológicos:
- **Backend**:
  - Java 17+
  - Spring Boot
  - Dependencias: Spring Security, Spring Data JPA, JWT, Lombok, MySQL/PostgreSQL.
- **Frontend**:
  - Spring MVC
  - Thymeleaf
  - Bootstrap

### Herramientas:
- IDE: IntelliJ IDEA / Eclipse
- Cliente REST: Insomnia / Postman
- Base de Datos: MySQL o PostgreSQL
- Control de versiones: Git

---

## Estructura del Proyecto
### Backend
- **Models**:
  - `Alumno`: Atributos: id, rut, nombre, dirección, materiaList.
  - `Materia`: Atributos: id, nombre, alumno.
  - `User`: Atributos: id, name, username, email, roles.
  - `Role`: Enumeración con valores `ROLE_ADMIN`, `ROLE_CLIENT`.
- **Repositories**:
  - `AlumnoRepository`
  - `MateriaRepository`
  - `UserRepository`
- **Services**:
  - `AlumnoService`: Métodos `save`, `findAll`.
  - `MateriaService`: Método `save`.
  - `UserService`: Métodos `signin`, `signup`, `loadUserByUsername`.
- **Controllers**:
  - `AlumnoController`: Métodos `findAll`, `save`.
  - `MateriaController`: Método `save`.
  - `UserController`: Métodos `signin`, `signup`.
- **Security**:
  - `JwtTokenProvider`, `JwtTokenFilter`, `JwtTokenFilterConfigurer`.
  - `WebSecurityConfig`: Configuración de seguridad de la aplicación.
- **Logger**: Configurado para registrar eventos.

### Frontend
- **DTOs**:
  - `AlumnoDTO`
  - `MateriaDTO`
  - `UserDTO`
- **Services**:
  - `AlumnoService`: Método `findAll` (consumo de API REST).
  - `UserService`: Método `signin` (inicio de sesión).
- **Controllers**:
  - `LoginController`: Métodos `login`, `home`.
- **Vistas**:
  - `login.html`: Formulario de inicio de sesión.
  - `home.html`: Vista de alumnos y sus materias.

---
