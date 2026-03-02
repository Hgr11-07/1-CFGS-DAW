CREATE DATABASE base_2_0_2
CREATE TABLE medico(

    medicoID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    añoColegiado YEAR NOT NULL

);

CREATE TABLE paciente(

    pacienteID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    medicoID INT NOT NULL,
    FOREIGN KEY (medicoID) REFERENCES medico (medicoID)

);

CREATE TABLE sala(

    salaID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ubicacion VARCHAR(20)

);

CREATE TABLE pasaConsulta(

    medicoID INT NOT NULL,
    salaID INT NOT NULL,
    horario TIME,
    FOREIGN KEY (medicoID) REFERENCES medico (medicoID),
    FOREIGN KEY (salaID) REFERENCES sala (salaID),
    PRIMARY KEY (medicoID, salaID)


)

INSERT INTO medico (nombre, añoColegiado)
VALUES
('Carlos Herrera', 2010),
('María Ríos', 2015),
('Javier Ortega', 2008),
('Lucía Morales', 2020),
('Ana Delgado', 2012);

INSERT INTO paciente (nombre, medicoID) 
VALUES
('Laura Sánchez', 1),
('Miguel Torres', 2),
('Sara Núñez', 3),
('Andrés Castillo', 4),
('Elena Prieto', 5);

INSERT INTO sala (ubicacion) 
VALUES
('Planta 1'),
('Planta 1'),
('Planta 2'),
('Planta 2'),
('Planta 3');

INSERT INTO pasaConsulta (medicoID, salaID, horario) 
VALUES
(1, 1, '09:00:00'),
(2, 2, '10:30:00'),
(3, 3, '11:15:00'),
(4, 4, '14:00:00'),
(5, 5, '15:45:00');
