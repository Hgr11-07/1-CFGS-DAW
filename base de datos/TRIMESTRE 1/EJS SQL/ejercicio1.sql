CREATE DATABASE Base1;
CREATE TABLE
IF NOT EXISTS Libros(

    libroID INT AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    autor VARCHAR(20),
    añoPublicacion INT,
    categoria ENUM ('Ciencia-ficcion', 'Novela', 'Historia'),
    PRIMARY KEY (libroID)

);

CREATE TABLE
IF NOT EXISTS Usuario(

    usuarioID INT,
    nombre VARCHAR(20),
    PRIMARY KEY (usuarioID)

)

CREATE TABLE
IF NOT EXISTS Prestamo(

    prestamoID INT AUTO_INCREMENT,
    libroID INT NOT NULL,
    usuarioID INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFinal DATE NOT NULL,
    estáActivo CHAR(1) NOT NULL DEFAULT '1',
    PRIMARY KEY (prestamoID),
    FOREIGN KEY (libroID) REFERENCES Libros (libroID) ,
    FOREIGN KEY (usuarioID) REFERENCES Usuario (usuarioID)

)