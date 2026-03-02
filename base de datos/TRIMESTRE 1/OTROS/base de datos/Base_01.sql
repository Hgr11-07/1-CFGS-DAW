CREATE DATABASE BASE_2_0_1
CREATE TABLE Profesor(

    profesorID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    nacionalidad VARCHAR(20) NOT NULL

);

CREATE TABLE Nivel(

    nivelID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(20) NOT NULL UNIQUE,

);

CREATE TABLE Grupo(

    grupoID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    modulo VARCHAR(20) NOT NULL,
    profesorID INT NOT NULL,
    nivelID INT NOT NULL,
    FOREIGN KEY (profesorID) REFERENCES Profesor (profesorID),
    FOREIGN KEY (nivelID) REFERENCES Nivel (nivelID)

);

CREATE TABLE Alumno(

    alumnoID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    grupoID INT NOT NULL,
    FOREIGN KEY (grupoID) REFERENCES Grupo (grupoID)

)

INSERT INTO Profesor (nombre, nacionalidad) 
VALUES
('Ana López', 'Española'),
('John Smith', 'Inglesa'),
('Maria Rossi', 'Italiana'),
('Carlos García', 'Mexicana'),
('Emma Müller', 'Alemana');

INSERT INTO Nivel (titulo) 
VALUES
('Básico'),
('Intermedio'),
('Avanzado'),
('Experto'),
('Master');

INSERT INTO Grupo (modulo, profesorID, nivelID) 
VALUES
('Matemáticas', 1, 1),
('Física', 2, 2),
('Química', 3, 3),
('Historia', 4, 4),
('Literatura', 5, 5);

INSERT INTO Alumno (nombre, grupoID) 
VALUES
('Laura Gómez', 1),
('Miguel Torres', 2),
('Sara López', 3),
('Andrés Castillo', 4),
('Elena Prieto', 5);
