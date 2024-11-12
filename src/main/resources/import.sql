-- Insertar el primer estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('12345678-9', 'Juan Pérez', 'Av. Libertador 1234, Santiago', 'juan.perez@email.com');

-- Insertar el segundo estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('98765432-1', 'María González', 'Calle Falsa 567, Valparaíso', 'maria.gonzalez@email.com');

-- Insertar el tercer estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('11223344-5', 'Carlos López', 'Paseo Los Nogales 890, Concepción', 'carlos.lopez@email.com');

-- Insertar el cuarto estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('55667788-0', 'Ana Torres', 'Av. Los Álamos 2345, La Serena', 'ana.torres@email.com');

-- Insertar el quinto estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('99887766-4', 'Luis Rodríguez', 'Calle del Sol 5678, Antofagasta', 'luis.rodriguez@email.com');


INSERT INTO subjects (name) VALUES ('Matemáticas');
INSERT INTO subjects (name) VALUES ('Lenguaje');
INSERT INTO subjects (name) VALUES ('Ciencias');
INSERT INTO subjects (name) VALUES ('Historia');
INSERT INTO subjects (name) VALUES ('Inglés');

-- Relación de Juan Perez con Matemáticas y Ciencias
INSERT INTO Student_Subject (student_id, subject_id) VALUES (1, 1), (1, 3);

-- Relación de Maria Gomez con Matemáticas, Lenguaje, e Inglés
INSERT INTO Student_Subject (student_id, subject_id) VALUES (2, 1), (2, 2), (2, 5);

-- Relación de Pedro Fernandez con Historia y Ciencias
INSERT INTO Student_Subject (student_id, subject_id) VALUES (3, 4), (3, 3);

-- Relación de Ana Ramirez con Matemáticas y Inglés
INSERT INTO Student_Subject (student_id, subject_id) VALUES (4, 1), (4, 5);

-- Relación de Luis Martinez con Ciencias, Historia y Lenguaje
INSERT INTO Student_Subject (student_id, subject_id) VALUES (5, 3), (5, 4), (5, 2);