CREATE DATABASE Base_2_0_4

CREATE TABLE Modulo(

    moduloID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codigo INT NOT NULL UNIQUE,
    nombre VARCHAR(30) NOT NULL

);

CREATE TABLE Profesor(

    profesorID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR (40) NOT NULL,
    telefono INT NOT NULL,
    direccion VARCHAR (255) NOT NULL,
    DNI INT NOT NULL UNIQUE

);

CREATE TABLE Grupo(

    grupoID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    nivelEducativo VARCHAR(10) NOT NULL

);

CREATE TABLE Alumno(

    alumnoID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    grupoID INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    numExpediente INT NOT NULL,
    fechaNacimiento DATE NOT NULL,
    FOREIGN KEY (grupoID) REFERENCES Grupo (grupoID)

);

CREATE TABLE SeMatricula(

    alumnoID INT NOT NULL,
    moduloID INT NOT NULL,
    PRIMARY KEY (alumnoID, moduloID),
    CONSTRAINT FK_SM_Alumno FOREIGN KEY (alumnoID) REFERENCES Alumno (alumnoID),
    FOREIGN KEY (moduloID) REFERENCES Modulo (moduloID)

)

INSERT INTO Modulo (codigo, nombre) 
VALUES
(101, 'Matemáticas'),
(102, 'Física'),
(103, 'Química'),
(104, 'Historia'),
(105, 'Literatura');

INSERT INTO Profesor (nombre, telefono, direccion, DNI) 
VALUES
('Ana López', 600123456, 'Calle Mayor 12, Madrid', 12345678),
('Carlos García', 611234567, 'Av. Libertad 45, Barcelona', 87654321),
('Maria Rossi', 622345678, 'Via Roma 10, Roma', 11223344),
('John Smith', 633456789, 'Baker Street 221, Londres', 99887766),
('Emma Müller', 644567890, 'Hauptstrasse 5, Berlín', 55443322);

INSERT INTO Grupo (nombre, nivelEducativo) 
VALUES
('1º ESO', 'ESO'),
('2º ESO', 'ESO'),
('3º ESO', 'ESO'),
('4º ESO', 'ESO'),
('1º Bachillerato', 'Bach');

INSERT INTO Alumno (grupoID, nombre, apellido, numExpediente, fechaNacimiento) 
VALUES
(1, 'Laura', 'Gómez', 1001, '2009-05-12'),
(2, 'Miguel', 'Torres', 1002, '2008-11-03'),
(3, 'Sara', 'López', 1003, '2007-07-21'),
(4, 'Andrés', 'Castillo', 1004, '2006-02-15'),
(5, 'Elena', 'Prieto', 1005, '2005-09-30');

INSERT INTO SeMatricula (alumnoID, moduloID) 
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);



