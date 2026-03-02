CREATE DATABASE Ejercicio_1Simulacro;

CREATE TABLE ciclista(

    dorsal INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    nacionalidad VARCHAR(25) NOT NULL,
    mejoresClasificaciones VARCHAR(255) NOT NULL

);

CREATE TABLE equipo(

    equipoID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    nacionalidad VARCHAR(25) NOT NULL,
    patrocinador VARCHAR(30),
    director VARCHAR(60) NOT NULL,
    dorsal INT NOT NULL,
    CONSTRAINT FK_Equipo_Ciclista FOREIGN KEY (dorsal) REFERENCES ciclista (dorsal)

);

CREATE TABLE puerto(

    puertoID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    categoria VARCHAR(30) NOT NULL

);

CREATE TABLE etapa(

    numEtapa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    numKm INT NOT NULL,
    lugarSalida VARCHAR(60) NOT NULL,
    lugarLlegada VARCHAR(60) NOT NULL,
    horaSalida TIME NOT NULL,
    horaLlegada TIME NOT NULL,
    puertoID INT NOT NULL,
    CONSTRAINT FK_Etapa_Puerto FOREIGN KEY (puertoID) REFERENCES puerto (puertoID)

);

CREATE TABLE entrevista(

    entrevistaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    numEntrevistas INT NOT NULL,
    cadena VARCHAR(30) NOT NULL,
    nombreCiclista NOT NULL,
    
);

CREATE TABLE pasaPor(

    puertoID INT NOT NULL,
    numEtapa INT NOT NULL,
    puertoMontaña INT NOT NULL,
    PRIMARY KEY (puertoID, numEtapa),
    FOREIGN KEY (puertoID) REFERENCES puerto (puertoID),
    FOREIGN KEY (numEtapa) REFERENCES etapa (numEtapa)

);

CREATE TABLE hace(

    dorsal INT NOT NULL,
    numEtapa INT NOT NULL,
    tiempoInvertido INT NOT NULL,
    PRIMARY KEY (dorsal, numEtapa),
    FOREIGN KEY (dorsal) REFERENCES ciclista (dorsal),
    FOREIGN KEY (numEtapa) REFERENCES etapa (numEtapa)

);

CREATE TABLE concede(

    dorsal INT NOT NULL,
    entrevistaID INT NOT NULL,
    PRIMARY KEY (dorsal, entrevistaID),
    FOREIGN KEY (dorsal) REFERENCES ciclista (dorsal),
    FOREIGN KEY (entrevistaID) REFERENCES entrevista (entrevistaID)

)