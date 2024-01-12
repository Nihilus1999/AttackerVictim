/* FUNCIONES DE BASE DE DATOS */

USE attackervictim_db;

DESCRIBE administrador;
DESCRIBE usuario;
DESCRIBE usuario_victima;
DESCRIBE usuario_atacante;
DESCRIBE historico_usuario;
DESCRIBE zona_segura;
DESCRIBE coordenadas;

/* INSERTS - ATTACKERVICTIM */


/*ADMINISTRADOR*/
INSERT INTO administrador (alias, correo, clave)
VALUES ('admin1', 'admin1@example.com', 'clave1');
INSERT INTO administrador (alias, correo, clave)
VALUES ('admin2', 'admin2@example.com', 'clave2');
INSERT INTO administrador (alias, correo, clave)
VALUES ('admin3', 'admin3@example.com', 'clave3');



/* USUARIOS */
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Lorenzo', 1, 'Asmar', 'lorasmar', 'V-33.333.333', 'loren.com', '00-B0-D0-63-C2-27','lorasmar');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Ertha', 1, 'Gyorffy', 'egyorffy0', 'V-97.681.278', 'egyorffy0@independent.co.uk', 'D2-F1-D8-AE-D1-C5','egyorffy0');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Stephan', 1, 'Horsley', 'shorsley1', 'V-623.446.183', 'shorsley1@foxnews.com', 'A7-AA-CC-52-18-D8','shorsley1');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Libbie', 1, 'Stable', 'lstable2', 'V-327.262.630', 'lstable2@feedburner.com', '8F-30-09-B8-6E-1A','lstable2');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Anthony', 1, 'Rubury', 'arubury3', 'V-213.675.012', 'arubury3@shutterfly.com', '0E-A6-AC-7E-95-1C','arubury3');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Wake', 1, 'Gayler', 'wgayler4', 'V-511.648.881', 'wgayler4@geocities.com', 'AD-E2-ED-7E-76-74','wgayler4');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Saleem', 1, 'Karpfen', 'skarpfen5', 'V-22.444.838', 'skarpfen5@yale.edu', '9D-5A-33-44-35-59','skarpfen5');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Silvan', 0, 'Dand', 'sdand6', 'V-386.332.428', 'sdand6@arizona.edu', '28-E7-27-BF-F7-5C','sdand6');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Mariann', 0, 'Tooher', 'mtooher7', 'V-876.643.924', 'mtooher7@google.co.uk', '1D-0C-73-FB-62-4E','mtooher7');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Lonna', 0, 'Howe', 'lhowe8', 'V-32.523.477', 'lhowe8@japanpost.jp', 'B7-07-05-C9-64-66','lhowe8');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Catina', 0, 'Heathwood', 'cheathwood9', 'V-78.716.837', 'cheathwood9@google.pl', 'A5-83-50-3B-03-AD','cheathwood9');

/* NOTIFICACION */
    
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (1, 'Alerta 1', 'alerta', 1);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (2, 'Alerta 2', 'alerta', 2);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (3, 'Alerta 3', 'alerta', 3);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (4, 'Alerta 4', 'alerta', 4);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (5, 'Alerta 5', 'alerta', 5);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (6, 'Alerta 6', 'alerta', 6);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (7, 'Alerta 7', 'alerta', 7);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (8, 'Alerta 8', 'alerta', 8);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (9, 'Alerta 9', 'alerta', 9);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (10, 'Alerta 10', 'alerta', 10);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (11, 'SOS 1', 'SOS', 1);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (12, 'SOS 2', 'SOS', 2);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (13, 'SOS 3', 'SOS', 3);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (14, 'SOS 4', 'SOS', 4);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (15, 'SOS 5', 'SOS', 5);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (16, 'SOS 6', 'SOS', 6);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (17, 'SOS 7', 'SOS', 7);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (18, 'SOS 8', 'SOS', 8);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (19, 'SOS 9', 'SOS', 9);
INSERT INTO notificacion (id, descripcion, tipo, id_usuario) VALUES (20, 'SOS 10', 'SOS', 10);


/* HISTORICO_USUARIO */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00', 37.123456, -122.987654, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-02 11:30:00', 40.987654, -74.123456, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 14:15:00', 35.678901, -82.345678, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-02 16:45:00', 42.345678, -71.234567, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 18:20:00', 38.901234, -77.890123, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-02 20:00:00', 33.456789, -112.345678, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 22:30:00', 39.012345, -94.567890, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 01:15:00', 36.789012, -119.012345, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-03 04:00:00', 41.234567, -87.901234, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.567890, -118.789012, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.51, -118.72, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.52, -118.73, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.53, -118.74, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.54, -118.75, 1);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 10.464699, -66.976735, 2);
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (0, '2023-12-03 07:30:00', 34.53, -118.74, 2);



/* USUARIO_VICTIMA */
INSERT INTO usuario_victima (id_usuario) VALUES (1);
INSERT INTO usuario_victima (id_usuario) VALUES (3);
INSERT INTO usuario_victima (id_usuario) VALUES (5);
INSERT INTO usuario_victima (id_usuario) VALUES (7);



/* USUARIO_ATACANTE */
INSERT INTO usuario_atacante (id_usuario) VALUES (2);
INSERT INTO usuario_atacante (id_usuario) VALUES (4);
INSERT INTO usuario_atacante (id_usuario) VALUES (6);
INSERT INTO usuario_atacante (id_usuario) VALUES (8);



/* RELACION_VICTIMA-ATACANTE */
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (2000.15, 6, 1, 1);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (15.75, 5, 2, 2);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (20.45, 3, 3, 3);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (25.20, 4, 4, 4);




/* ZONAS_SEGURAS */
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Los Angeles', 1);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('New York City', 1);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('London', 1);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Tokyo', 2);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Paris', 2);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Sydney', 2);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Rio de Janeiro', 3);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Rome', 3);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Cairo', 3);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('Cairo', 4);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('UCAB', 1);



/* COORDENADAS */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (37.774932547187497, -122.419415495872395, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (51.507222222222221, -0.127600000000000, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (-33.865099999999999, 151.209899999999993, 2);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (34.052200000000004, -118.243700000000006, 2);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (48.856600000000001, 2.352200000000000, 3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (-22.906800000000000, -43.172900000000000, 3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (35.689500000000001, 139.691700000000000, 3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (55.755800000000000, 37.617600000000000, 4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (-12.046400000000000, -77.042800000000000, 4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (30.044400000000000, 31.235700000000000, 4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.464380, -66.978726,11 );
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465496, -66.977413, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465927, -66.975895, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465469, -66.973420, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.464810, -66.973215, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.463035, -66.976306, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.460823, -66.976544, 11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.460653, -66.977628, 11);

/* QUERY ULTIMO INSERT DE HISTORICO DE VICTIMA Y ATACANTE */
SELECT hu.* FROM historico_usuario hu INNER JOIN ((SELECT MAX(hu.id) AS ultimo_registro, 'usuario_victima' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_victima WHERE rva.id = 1 GROUP BY entidad) UNION (SELECT MAX(hu.id) AS ultimo_registro, 'usuario_atacante' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = 1 GROUP BY entidad)) ult ON hu.id = ult.ultimo_registro;

/* QUERY DEL ULTIMO HISTORICO DEL ATACANTE */
SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = 1 ORDER BY hu.id DESC LIMIT 1;

/* QUERY DEL ULTIMO HISTORICO DE LA VICTIMA */
SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_atacante WHERE rva.id = 1 ORDER BY hu.id DESC LIMIT 1;
