--1.
SELECT v.nombre, v.genero FROM videojuegos v WHERE plataforma='Multiplataforma';
--2.
SELECT COUNT(v.id) numVideojuegos FROM videojuegos v WHERE v.genero='Accion';
--3.
SELECT DISTINCT v.plataforma FROM videojuegos v;
--4.
SELECT v.nombre, v.fecha_lanzamiento FROM videojuegos v WHERE fecha_lanzamiento>='2017-05-05' AND fecha_lanzamiento<='2019-05-05';
--5.
SELECT nombre, email FROM jugadores j WHERE j.nombre='a%';
--6.
SELECT v.nombre, p.duracion_minutos FROM partidas p INNER JOIN videojuegos v ON p.videojuego_id=v.id WHERE p.duracion_minutos IN(SELECT max(p.duracion_minutos) FROM partidas p);
--7.
SELECT AVG(duracion_minutos) media_minutos FROM partidas p;
--8.
SELECT j.nombre, v.nombre, jp.puntuacion FROM jugadores_partidas jp INNER JOIN jugadores j ON jp.jugador_id=j.id INNER JOIN partidas p ON jp.partida_id=p.id INNER JOIN videojuegos v ON p.videojuego_id=v.id WHERE jp.puntuacion IN(SELECT MIN(puntuacion) FROM jugadores_partidas);
--9.
SELECT v.plataforma, SUM(jp.puntuacion) puntuacion_total FROM jugadores_partidas jp INNER JOIN partidas p ON jp.partida_id=p.id INNER JOIN videojuegos v ON p.videojuego_id=v.id GROUP BY v.plataforma HAVING v.plataforma='PLAYSTATION 4';
--10.
SELECT v.plataforma, COUNT(jp.partida_id) partidas_jugadas FROM jugadores_partidas jp INNER JOIN partidas p ON jp.partida_id=p.id INNER JOIN videojuegos v ON p.videojuego_id=v.id GROUP BY v.plataforma;