CREATE DATABASE Base_2_0_5

CREATE TABLE Cliente(

    clienteID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    NIF VARCHAR(20) NOT NULL UNIQUE,
    telefono INT NOT NULL UNIQUE,
    direccion VARCHAR(255) NOT NULL,
    ciudad VARCHAR (30) NOT NULL

);

CREATE TABLE Coche(

    cocheID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR (255) NOT NULL,
    color VARCHAR (20) NOT NULL,
    precioVenta FLOAT NOT NULL

);

CREATE TABLE Revision(

    revisionID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cambioFiltro VARCHAR(30) NOT NULL,
    cambioAceite VARCHAR(30) NOT NULL,
    cambioFreno VARCHAR(30) NOT NULL,
    codigo VARCHAR(30) NOT NULL UNIQUE,
    cocheID INT NOT NULL UNIQUE,
    FOREIGN KEY (cocheID) REFERENCES Coche (cocheID)

)

INSERT INTO Cliente (ciudad, NIF, nombre, telefono, direccion) 
VALUES
('Madrid', '12345678A', 'Laura Gómez', '600123456', 'Calle Mayor 12, Madrid'),
('Barcelona', '87654321B', 'Carlos Ruiz', '611234567', 'Av. Diagonal 45, Barcelona'),
('Sevilla', '11223344C', 'María López', '622345678', 'Calle Real 55, Sevilla'),
('Valencia', '99887766D', 'Javier Torres', '633456789', 'Paseo del Río 89, Valencia'),
('Bilbao', '55443322E', 'Ana Martínez', '644567890', 'Rua Libertad 12, Bilbao');

INSERT INTO Coche (matricula, marca, modelo, color, precioVenta) 
VALUES
('1234ABC', 'Toyota', 'Corolla', 'Blanco', 18000.00),
('5678DEF', 'Ford', 'Focus', 'Negro', 17000.00),
('9012GHI', 'BMW', 'Serie 3', 'Azul', 35000.00),
('3456JKL', 'Audi', 'A4', 'Rojo', 37000.00),
('7890MNO', 'Mercedes', 'C200', 'Plata', 40000.00);

INSERT INTO Revision (cambioFiltro, cambioAceite, cambioFreno, codigo, cocheID) 
VALUES
('Sí', 'Sí', 'No', 'REV001', 1),
('No', 'Sí', 'Sí', 'REV002', 2),
('Sí', 'No', 'Sí', 'REV003', 3),
('Sí', 'Sí', 'Sí', 'REV004', 4),
('No', 'No', 'Sí', 'REV005', 5);

