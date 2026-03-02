CREATE DATABASE Ejercicio_3_05_2;

CREATE TABLE recintos(

    cod_recinto INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    ciudad VARCHAR (60) NOT NULL,
    telefono INT NOT NULL,
    horario VARCHAR (30) NOT NULL

);

CREATE TABLE espectaculos(

    cod_espectaculo INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    fecha_inicial DATE NOT NULL,
    fecha_final DATE NOT NULL,
    interprete VARCHAR(60) NOT NULL,
    cod_recinto INT NOT NULL,
    FOREIGN KEY (cod_recinto) REFERENCES recintos (cod_recinto)

);

CREATE TABLE precios_espectaculos(

    cod_espectaculo INT NOT NULL PRIMARY KEY,
    cod_recinto INT NOT NULL,
    zona VARCHAR(60) NOT NULL,
    precio FLOAT NOT NULL,
    PRIMARY KEY (cod_espectaculo, cod_recinto, zona),
    FOREIGN KEY (cod_espectaculo) espectaculos (cod_espectaculo),
    FOREIGN KEY (cod_recinto) recintos (cod_recinto)

);

CREATE TABLE zonas_recintos(

    cod_recinto INT NOT NULL PRIMARY KEY,
    zona VARCHAR(60) NOT NULL,
    capacidad INT NOT NULL,
    FOREIGN KEY (cod_recinto) REFERENCES recintos (cod_recinto)

);

CREATE TABLE asientos(

    cod_recinto INT NOT NULL,
    zona VARCHAR(60) NOT NULL,
    fila INT NOT NULL,
    numero INT NOT NULL,
    PRIMARY KEY (cod_recinto, zona, fila, numero),
    FOREIGN KEY (cod_recinto, zona) REFERENCES zonas_recintos (cod_recinto, zona)

);

CREATE TABLE representaciones(

    cod_espectaculo INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    PRIMARY KEY (cod_espectaculo, fecha, hora),
    FOREIGN KEY (cod_espectaculo) REFERENCES espectaculos (cod_espectaculo) 

);

CREATE TABLE entradas(

    cod_espectaculo INT NOT NULL,
    fecha DATE NOT NULL,
    hora DATE NOT NULL,
    cod_recinto INT NOT NULL,
    fila INT NOT NULL,
    numero INT NOT NULL,
    zona VARCHAR(60) NOT NULL,
    DNI_cliente VARCHAR(20) NOT NULL,
    PRIMARY KEY (cod_espectaculo, fecha, hora, fila, numero, zona, DNI_cliente),
    FOREIGN KEY (cod_espectaculo) REFERENCES espectaculos (cod_espectaculo),
    FOREIGN KEY (cod_recinto, zona, fila, numero) REFERENCES asientos (cod_recinto, zona, fila, numero), 
    FOREIGN KEY (DNI_cliente) REFERENCES espectadores (DNI_cliente)

);

CREATE TABLE espectadores(

    DNI_cliente VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono INT NOT NULL,
    ciudad VARCHAR (60),
    ntarjeta INT NOT NULL

)
