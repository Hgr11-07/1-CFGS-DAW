CREATE DATABASE Pruebas;
USE Pruebas;

CREATE TABLE alumnado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL
)

INSERT INTO alumnado (nombre, apellido, curso) VALUES
('Juan', 'Pérez', 'Matemáticas'),
('María', 'Gómez', 'Física'),
('Carlos', 'López', 'Química'),
('Ana', 'Martínez', 'Biología'),
('Luis', 'Sánchez', 'Historia');