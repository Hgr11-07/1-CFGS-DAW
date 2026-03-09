CREATE TABLE cuentas (
    id INTEGER UNSIGNED PRIMARY KEY,
    saldo DECIMAL(11,2) CHECK (saldo >= 0)
);

INSERT INTO cuentas VALUES (1, 1000);
INSERT INTO cuentas VALUES (2, 2000);
INSERT INTO cuentas VALUES (3, 0);

START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
-- ¿Qué contiene cuentas en este momento?
-- Contiene tres cuentas, una con saldo 900€, otra con 2100€ y la última con 0€.

START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 9999;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
-- ¿Qué sucede cuando una cuenta no existe? ¿Se ha modificado el saldo de la cuenta 2?
-- Que no realiza la operación de la cuenta 9999, pero sí la de la cuenta 2, cuyo saldo ahora es 2200€.

START TRANSACTION;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 3;
COMMIT;

-- ¿Y si una cuenta no tiene saldo? ¿Se han modificado ambos los saldos?
-- Que da un error y no se pueden realizar las operaciones, por lo que no se modifica ningún saldo.

-- A continuación, indica las sentencias SQL necesarias para realizar las siguientes tareas dentro de una única operación:

    --Inserta una nueva cuenta, la 4, con un saldo de 400€.
    --Inserta la cuenta 5 con un saldo de 500€.
    --Modifica la cuenta 3 para que su saldo sea 300€.

START TRANSACTION;
INSERT INTO cuentas VALUES (4, 400);
INSERT INTO cuentas VALUES (5, 500);
UPDATE cuentas SET saldo = saldo + 300 WHERE id = 3;
COMMIT;

-- Y en otra operación:

    --Inserta la cuenta 6 con un saldo de 600€.
    --Modifica las cuentas 4 y 5 y quítales 200€ (en una única operación).
    --Deshaz las dos últimas operaciones.

START TRANSACTION;
INSERT INTO cuentas VALUES (6, 600);
UPDATE cuentas SET saldo=saldo-200 WHERE id IN(4,5);
ROLLBACK;
