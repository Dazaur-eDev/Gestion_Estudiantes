# Aplicación para el Control de Notas de Estudiantes - Universidad de Los Andes

La Universidad de Los Andes necesita desarrollar una aplicación que trabaje en conjunto con una API para llevar el control de notas de los estudiantes en carreras de pregrado. La aplicación debe cumplir con los siguientes requisitos funcionales.

---

## Requisitos de la Aplicación

### Funcionalidad Principal

- Sistema para manejar datos de estudiantes y sus materias asignadas.
- Desarrollo de un servicio REST utilizando **Spring** para contener la lógica de alumnos y materias.
- Autenticación mediante **JWT (JSON Web Token)**.
- Pruebas de endpoints para crear alumnos, materias, y usuarios usando herramientas como **Insomnia**.
- Inicio de sesión para obtener un token JWT y registro de alumnos con materias asignadas.
- Visualización de los datos mediante una aplicación con **Spring** que permita:
    - Iniciar sesión a través de un formulario.
    - Validar la autenticación contra el servicio REST.
    - Mostrar una vista con menú que incluya la lista de alumnos y sus materias.

---