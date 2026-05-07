CREATE DATABASE Pruebas;
USE Pruebas;

CREATE TABLE alumnado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    email VARCHAR(200) NOT NULL
)

INSERT INTO alumnado (nombre, apellido, curso) VALUES
('Hugo', 'Garcia', 'BD');
('María', 'Gómez', 'Física'),
('Carlos', 'López', 'Química'),
('Ana', 'Martínez', 'Biología'),
('Luis', 'Sánchez', 'Historia');

DELIMITER $$
CREATE OR REPLACE FUNCTION crearEmail (nombre VARCHAR(50), apellidos VARCHAR(50), curso VARCHAR(50)) 
RETURNS VARCHAR(200)
BEGIN
DECLARE email VARCHAR(200);
SET email = CONCAT(LEFT(LOWER(nombre), 1), LEFT(LOWER(apellidos), 5), LENGTH(apellidos), '@', LOWER(curso), '.kursal.es');
return email;

END $$
DELIMITER ;
SELECT crearEmail('Hugo', 'Garcia', 'BD');

ALTER TABLE alumnado ADD COLUMN email VARCHAR(200) NOT NULL;

CREATE PROCEDURE actualizarEmail()
BEGIN
UPDATE alumnado
SET email = crearEmail(nombre, apellido, curso);
END $$