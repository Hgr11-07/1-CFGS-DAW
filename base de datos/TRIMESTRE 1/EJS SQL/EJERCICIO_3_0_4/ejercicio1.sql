CREATE DATABASE EjercicioExamen1;

CREATE TABLE persona(

    idPersona INT(5) PRIMARY KEY,
    pais VARCHAR(30) NOT NULL,
    nombreCompleto VARCHAR(40) NOT NULL

);

CREATE TABLE piloto(

    idPiloto INT(5) PRIMARY KEY,
    apodo VARCHAR(20) NOT NULL

);

CREATE TABLE jefeEquipo(

    idJefe INT(5) PRIMARY KEY

);

CREATE TABLE carrera(

    idCarrera INT(5) PRIMARY KEY,
    numCarrera INT (3) NOT NULL,
    ciudad VARCHAR(30) NOT NULL,
    fecha DATE NOT NULL

);

CREATE TABLE coche(

    idCoche INT(5) PRIMARY KEY,
    motor VARCHAR(20) NOT NULL,
    idCarrera INT NOT NULL,
    idPiloto INT NOT NULL,
    FOREIGN KEY (idCarrera) REFERENCES carrera (idCarrera),
    FOREIGN KEY (idPiloto) REFERENCES piloto (idPiloto)

);

CREATE TABLE equipo(

    idEquipo INT(5) PRIMARY KEY,
    nomConstructor VARCHAR(20),
    patrocinador VARCHAR(20),
    idPiloto INT NOT NULL,
    idCoche INT NOT NULL,
    FOREIGN KEY (idPiloto) REFERENCES piloto (idPiloto),
    FOREIGN KEY (idCoche) REFERENCES coche (idCoche)

);

CREATE TABLE participa(

    idCarrera INT NOT NULL,
    idPiloto INT NOT NULL,
    idCoche INT NOT NULL,
    hora TIME NOT NULL,
    dorsal INT(3) NOT NULL,
    posicion VARCHAR(3) NOT NULL,
    PRIMARY KEY (idCarrera, idPiloto, idCoche),
    FOREIGN KEY (idCarrera) REFERENCES carrera (idCarrera),
    FOREIGN KEY (idPiloto) REFERENCES piloto (idPiloto),
    FOREIGN KEY (idCoche) REFERENCES coche (idCoche)

)


