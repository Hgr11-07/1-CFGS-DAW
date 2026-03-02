CREATE DATABASE Base_2_0_3

CREATE TABLE Cliente(

    clienteID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    ciudad VARCHAR(40) NOT NULL,
    DNI VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR (30) NOT NULL

);

CREATE TABLE Sucursal(

    sucursalID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ciudad VARCHAR (40) NOT NULL,
    activo VARCHAR (20) NOT NULL,
    numSucursal INT NOT NULL UNIQUE

);

CREATE TABLE Cuenta(

    cuentaID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numCuenta INT NOT NULL UNIQUE,
    saldo FLOAT NOT NULL,

);

CREATE TABLE Transaccion(

    transaccionID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL

);

CREATE TABLE Abre(

    clienteID INT NOT NULL,
    cuentaID INT NOT NULL,
    PRIMARY KEY (clienteID, cuentaID),
    FOREIGN KEY (clienteID) REFERENCES Cliente (clienteID),
    FOREIGN KEY (cuentaID) REFERENCES Cuenta (cuentaID)

)

INSERT INTO Transaccion (fecha, tipo, cantidad) 
VALUES

(2025-01-03, Depósito, 25),
(2025-01-10, Retiro, 100),
(2025-02-01, Transferencia, 499),
(2025-02-15, Depósito, 1200),
(2025-03-05, Transferencia, 4000);

INSERT INTO Cuenta (numCuenta, saldo) VALUES
(10024589, 1500.75),
(10024590, 250.00),
(10024591, 9876.50),
(10024592, 120.30),
(10024593, 540.00);


INSERT INTO Sucursal (ciudad, activo, numSucursal) VALUES
('Madrid', 'Sí', 101),
('Barcelona', 'Sí', 102),
('Sevilla', 'No', 103),
('Valencia', 'Sí', 104),
('Bilbao', 'No', 105);


INSERT INTO Cliente (direccion, ciudad, DNI, nombre) VALUES
('Calle Mayor 123', 'Madrid', '12345678A', 'Laura Gómez'),
('Av. Diagonal 450', 'Barcelona', '87654321B', 'Carlos Ruiz'),
('Calle Real 55', 'Sevilla', '11223344C', 'María López'),
('Paseo del Río 89', 'Valencia', '99887766D', 'Javier Torres'),
('Rua Libertad 12', 'Bilbao', '55443322E', 'Ana Martínez');


INSERT INTO Abre (clienteID, cuentaID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
