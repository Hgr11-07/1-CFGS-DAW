CREATE DATABASE Ejercicio_3_05_3;

CREATE TABLE empleados(

    DNI NUMBER(8) NOT NULL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL,
    apellido1 VARCHAR(15) NOT NULL,
    apellido2 VARCHAR(15),
    direcc1 VARCHAR(25),
    direcc2 VARCHAR(20),
    ciudad VARCHAR(20),
    provincia VARCHAR(20),
    cod_postal VARCHAR(5),
    sexo ENUM ('M', 'F'),
    fecha_nac DATE

);

CREATE TABLE historial_laboral(

    empleado_DNI NUMBER(8),
    trabajo_cod NUMBER(5),
    fecha_inicio DATE,
    fecha_fin DATE,
    dpto_cod NUMBER(5),
    supervisor_DNI NUMBER(8),
    PRIMARY KEY (empleado_DNI, trabajo_cod, dpto_cod),
    FOREIGN KEY (empleado_DNI) REFERENCES empleados (DNI),
    FOREIGN KEY (trabajo_cod) REFERENCES trabajos (trabajo_cod),
    FOREIGN KEY (dpto_cod) REFERENCES departamentos (dpto_cod)

);

CREATE TABLE historial_salarial(

    empleado_DNI NUMBER(8),
    salario NUMBER NOT NULL,
    fecha_comienzo DATE,
    fecha_fin DATE,
    PRIMARY KEY (empleado_DNI, salario),
    FOREIGN KEY (empleado_DNI) REFERENCES empleados(empleado_DNI)


);

CREATE TABLE departamentos(

    dpto_cod NUMBER(5) PRIMARY KEY,
    nombre_dpto VARCHAR(30) UNIQUE,
    dpto_padre VARCHAR(5),
    presupuesto NUMBER NOT NULL,
    pres_actual NUMBER

);

CREATE TABLE estudios(

    empleado_DNI NUMBER(8),
    universidad NUMBER(5),
    año NUMBER,
    grado VARCHAR(20),
    especialidad VRACAR(20)

);

CREATE TABLE universidades(

    univ_cod NUMBER(5),
    nombre_univ VARCHAR(25),
    ciudad VARCHAR(20),
    municipio VARCHAR(2),
    cod_postal VARCHAR(5)

);

CREATE TABLE trabajos(

    trabajo_cod NUMBER(5),
    nombre_trab VARCHAR(20) UNIQUE,
    salario_min NUMBER(2) NOT NULL,
    salario_max NUMBER(2) NOT NULL

)