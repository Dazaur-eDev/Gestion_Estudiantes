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

-- Insertar el sexto estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('44556677-8', 'Sofía Morales', 'Av. Central 123, Arica', 'sofia.morales@email.com');

-- Insertar el séptimo estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('33221144-7', 'Ricardo Castillo', 'Calle Nueva 456, Iquique', 'ricardo.castillo@email.com');

-- Insertar el octavo estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('77665544-3', 'Camila Vargas', 'Paseo Jardines 789, Temuco', 'camila.vargas@email.com');

-- Insertar el noveno estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('22334455-6', 'Javier Ortega', 'Av. Las Palmas 1010, Rancagua', 'javier.ortega@email.com');

-- Insertar el décimo estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('66554433-2', 'Paula Espinoza', 'Calle Las Rosas 2020, Talca', 'paula.espinoza@email.com');

-- Insertar el undécimo estudiante
INSERT INTO students (rut, name, direction, email) VALUES ('55668899-1', 'Andrés Rojas', 'Camino Real 3030, Puerto Montt', 'andres.rojas@email.com');

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

-- Relación de Sofía Morales con Matemáticas y Lenguaje
INSERT INTO Student_Subject (student_id, subject_id) VALUES (6, 1), (6, 2);

-- Relación de Ricardo Castillo con Ciencias e Inglés
INSERT INTO Student_Subject (student_id, subject_id) VALUES (7, 3), (7, 5);

-- Relación de Camila Vargas con Matemáticas, Historia e Inglés
INSERT INTO Student_Subject (student_id, subject_id) VALUES (8, 1), (8, 4), (8, 5);

-- Relación de Javier Ortega con Ciencias, Lenguaje y Matemáticas
INSERT INTO Student_Subject (student_id, subject_id) VALUES (9, 3), (9, 2), (9, 1);

-- Relación de Paula Espinoza con Historia y Ciencias
INSERT INTO Student_Subject (student_id, subject_id) VALUES (10, 4), (10, 3);

-- Relación de Andrés Rojas con Inglés y Matemáticas
INSERT INTO Student_Subject (student_id, subject_id) VALUES (11, 5), (11, 1);