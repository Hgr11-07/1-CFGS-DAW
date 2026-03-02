CREATE DATABASE IF NOT EXISTS ventas; 

USE ventas;

CREATE TABLE cliente ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(25), 
    primer_apellido VARCHAR(15) NOT NULL, 
    ciudad VARCHAR(100), 
    categoria INT
);

CREATE TABLE comercial (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    nombre VARCHAR(100) NOT NULL, 
    apellido1 VARCHAR(100) NOT NULL, 
    apellido2 VARCHAR(100), 
    ciudad VARCHAR(100), 
    comision FLOAT
);

ALTER TABLE cliente
MODIFY nombre VARCHAR(100) NOT NULL;

DESCRIBE cliente;

ALTER TABLE cliente
CHANGE primer_apellido apellido1 VARCHAR(100) NOT NULL;

ALTER TABLE cliente
ADD COLUMN apellido2 VARCHAR(100) AFTER apellido1;

ALTER TABLE cliente
DROP COLUMN categoria;

ALTER TABLE comercial
MODIFY comision FLOAT DEFAULT 10;

