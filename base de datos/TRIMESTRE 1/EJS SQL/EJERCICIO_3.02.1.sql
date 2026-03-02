CREATE DATABASE Base_3.02.1;

CREATE TABLE Libro{

    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(50),
    añoPublicacion INT,
    categoria ENUM ('Ciencia-ficcion', 'Novela', 'Historia') NOT NULL

};

CREATE TABLE Prestamo{

    idPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    idLibro INT NOT NULL,
    idUsuario INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFinal DATE NOT NULL,
    activo BOOLEAN NOT NULL,
    CONSTRAINT FK_Prestamo_Libro FOREIGN KEY (idLibro) REFERENCES Libro (idLibro)

}

