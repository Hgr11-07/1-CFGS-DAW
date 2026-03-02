#Pregunta 1
SELECT nombre, email
FROM usuario
WHERE departamento = 'Recursos Humanos';

#Pregunta 2
SELECT *
FROM ticket
WHERE email_tecnico IS NULL
  AND prioridad = 'Alta';

#Pregunta 3
SELECT *
FROM ticket
WHERE descripcion LIKE '%servi%';

#Pregunta 4
SELECT COUNT(*) AS total_tickets_resueltos
FROM ticket
WHERE estado = 'Resuelto';

#Pregunta 5
SELECT departamento, COUNT(*) AS total_usuarios
FROM usuario
GROUP BY departamento;

#Pregunta 6
SELECT nombre, email
FROM tecnico
WHERE nombre LIKE '%ez'
UNION
SELECT nombre, email
FROM administrador
WHERE nombre LIKE '%ez'
ORDER BY nombre ASC;

#Pregunta 7
SELECT *
FROM ticket
WHERE estado = 'Pendiente'
ORDER BY fecha_creacion DESC;

#Pregunta 8
SELECT u.departamento, COUNT(t.idTicket) AS total_tickets
FROM ticket t
JOIN usuario u ON t.email_usuario = u.email
GROUP BY u.departamento;

#Pregunta 9
SELECT *
FROM ticket
WHERE estado = 'Resuelto'
  AND fecha_creacion >= DATE_SUB(NOW(), INTERVAL 5 DAY);

#Pregunta 10
SELECT estado, COUNT(*) AS cantidad
FROM ticket
GROUP BY estado;

#Pregunta 11
SELECT t.idTicket, t.descripcion, u.nombre
FROM ticket t
JOIN usuario u ON t.email_usuario = u.email
WHERE t.estado = 'Pendiente';

#Pregunta 12
SELECT t.idTicket, t.descripcion,
       u.nombre AS nombre_usuario,
       te.nombre AS nombre_tecnico
FROM ticket t
JOIN usuario u ON t.email_usuario = u.email
JOIN tecnico te ON t.email_tecnico = te.email
WHERE t.estado = 'En progreso';

#Pregunta 13
SELECT *
FROM ticket
WHERE estado = 'Resuelto'
  AND (categoria LIKE 'S%' OR categoria LIKE 'A%');

#Pregunta 14
SELECT te.nombre, COUNT(*) AS tickets_resueltos
FROM ticket t
JOIN tecnico te ON t.email_tecnico = te.email
WHERE t.estado = 'Resuelto'
GROUP BY te.email
ORDER BY tickets_resueltos DESC
LIMIT 3;

#Pregunta 15
SELECT te.nombre, te.email
FROM tecnico te
LEFT JOIN ticket t
  ON te.email = t.email_tecnico
  AND t.estado = 'Resuelto'
WHERE t.idTicket IS NULL;

#Pregunta 16
SELECT DAY(fecha_creacion) AS dia, COUNT(*) AS total_tickets
FROM ticket
WHERE MONTH(fecha_creacion) = 2
GROUP BY dia
ORDER BY total_tickets DESC
LIMIT 1;

#Pregunta 17
SELECT u.nombre, u.email, COUNT(t.idTicket) AS total_tickets
FROM usuario u
JOIN ticket t ON u.email = t.email_usuario
GROUP BY u.email
ORDER BY total_tickets DESC
LIMIT 5;

#Pregunta 18
SELECT t.descripcion, t.fecha_creacion, t.estado
FROM ticket t
WHERE t.email_tecnico = (
    SELECT email_tecnico
    FROM ticket
    WHERE estado = 'Resuelto'
    GROUP BY email_tecnico
    HAVING COUNT(*) >= 1
    ORDER BY COUNT(*) ASC
    LIMIT 1
);

#Pregunta 19
SELECT *
FROM ticket
ORDER BY fecha_creacion DESC
LIMIT 1;

#Pregunta 20
SELECT h.estado, h.fecha,
       t.descripcion,
       te.nombre AS nombre_tecnico,
       u.nombre AS nombre_usuario
FROM historial_ticket h
JOIN ticket t ON h.idTicket = t.idTicket
LEFT JOIN tecnico te ON t.email_tecnico = te.email
JOIN usuario u ON t.email_usuario = u.email
WHERE h.idTicket = 5
ORDER BY h.fecha;