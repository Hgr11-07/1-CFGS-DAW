CREATE DATABASE Ejercicio_3_05_1;

CREATE TABLE localidad(

    cod_localidad INT NOT NULL PRIMARY KEY,
    nombre VARCHAR (50) NOT NULL

);

CREATE TABLE pub(

    cod_pub VARCHAR(30) NOT NULL PRIMARY KEY,
    nombre VARCHAR (30) NOT NULL,
    licencia_fiscal VARCHAR (30) NOT NULL,
    domicilio VARCHAR (100),
    fecha_apertura DATE NOT NULL,
    horario ENUM ('HOR1', 'HOR2', 'HOR3') NOT NULL,
    cod_localidad INT NOT NULL,
    FOREIGN KEY (cod_localidad) REFERENCES localidad (cod_localidad) 

);

CREATE TABLE titular(

    DNI_titular VARCHAR(20) NOT NULL PRIMARY KEY,
    nombre VARCHAR (60) NOT NULL,
    cod_pub VARCHAR (30) NOT NULL,
    FOREIGN KEY (cod_pub) REFERENCES pub (cod_pub)

);

CREATE TABLE empleado(

    DNI_empleado VARCHAR (20) NOT NULL PRIMARY KEY,
    nombre VARCHAR (60) NOT NULL,
    domicilio VARCHAR (100)

);

CREATE TABLE existencias(

    cod_articulo VARCHAR (30) NOT NULL PRIMARY KEY,
    nombre VARCHAR (60) NOT NULL,
    cantidad INT NOT NULL,
    precio FLOAT NOT NULL CHECK (precio>0),
    cod_pub VARCHAR (30) NOT NULL,
    FOREIGN KEY (cod_pub) REFERENCES pub (cod_pub)  

);

CREATE TABLE pub_empleado(

    cod_pub VARCHAR (30) NOT NULL,
    DNI_empleado VARCHAR (20) NOT NULL,
    funcion ENUM ('CAMARERO', 'SEGURIDAD', 'LIMPIEZA') NOT NULL,
    PRIMARY KEY (cod_pub, DNI_empleado, funcion),
    FOREIGN KEY (cod_pub) REFERENCES pub (cod_pub),
    FOREIGN KEY (DNI_empleado) REFERENCES empleado (DNI_empleado)

)