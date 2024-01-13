/* FUNCIONES DE BASE DE DATOS */

USE attackervictim_db;

DESCRIBE administrador;
DESCRIBE usuario;
DESCRIBE usuario_victima;
DESCRIBE usuario_atacante;
DESCRIBE historico_usuario;
DESCRIBE notificacion;
DESCRIBE zona_segura;
DESCRIBE coordenadas;
DESCRIBE relacion_va;

/* INSERTS - ATTACKERVICTIM */


/* ADMINISTRADOR */
INSERT INTO administrador (alias, correo, clave)
VALUES ('nihilus', 'nihilus@gmail.com', 'nihilus');
INSERT INTO administrador (alias, correo, clave)
VALUES ('lagovisk', 'lagovisk@gmail.com', 'lagovisk');
INSERT INTO administrador (alias, correo, clave)
VALUES ('alayon', 'Alayon@gmail.com', 'alayon');



/* USUARIOS */
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Lorenzo', 1, 'Asmar', 'lorasmar', 'V-23.405.874', 'lorasmar@outlook.com', '00-B0-D0-63-C2-27','lorasmar');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Ertha', 1, 'Gyorffy', 'egyorffy0', 'V-97.681.278', 'egyorffy0@gmail.com', 'D2-F1-D8-AE-D1-C5','egyorffy0');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Stephan', 1, 'Horsley', 'shorsley1', 'V-623.446.183', 'shorsley1@hotmail.com', 'A7-AA-CC-52-18-D8','shorsley1');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Libbie', 1, 'Stable', 'lstable2', 'V-327.262.630', 'lstable2@gmail.com', '8F-30-09-B8-6E-1A','lstable2');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Anthony', 1, 'Rubury', 'arubury3', 'V-213.675.012', 'arubury3@gmail.com', '0E-A6-AC-7E-95-1C','arubury3');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Wake', 1, 'Gayler', 'wgayler4', 'V-511.648.881', 'wgayler4@hotmail.com', 'AD-E2-ED-7E-76-74','wgayler4');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Saleem', 1, 'Karpfen', 'skarpfen5', 'V-22.444.838', 'skarpfen5@outlook.com', '9D-5A-33-44-35-59','skarpfen5');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Silvan', 0, 'Dand', 'sdand6', 'V-386.332.428', 'sdand6@outlook.com', '28-E7-27-BF-F7-5C','sdand6');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Mariann', 0, 'Tooher', 'mtooher7', 'V-876.643.924', 'mtooher7@gmail.com', '1D-0C-73-FB-62-4E','mtooher7');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Lonna', 0, 'Howe', 'lhowe8', 'V-32.523.477', 'lhowe8@hotmail.com', 'B7-07-05-C9-64-66','lhowe8');
INSERT INTO usuario (nombre, activate, apellido, alias, cedula, correo, direccion_mac,clave)
VALUES ('Catina', 0, 'Heathwood', 'cheathwood9', 'V-78.716.837', 'cheathwood9@gmail.com', 'A5-83-50-3B-03-AD','cheathwood9');



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



/* USUARIO_VICTIMA */
INSERT INTO usuario_victima (id_usuario) VALUES (1);
INSERT INTO usuario_victima (id_usuario) VALUES (3);
INSERT INTO usuario_victima (id_usuario) VALUES (5);
INSERT INTO usuario_victima (id_usuario) VALUES (7);
INSERT INTO usuario_victima (id_usuario) VALUES (9);



/* USUARIO_ATACANTE */
INSERT INTO usuario_atacante (id_usuario) VALUES (2);
INSERT INTO usuario_atacante (id_usuario) VALUES (4);
INSERT INTO usuario_atacante (id_usuario) VALUES (6);
INSERT INTO usuario_atacante (id_usuario) VALUES (8);
INSERT INTO usuario_atacante (id_usuario) VALUES (10);



/* RELACION_VICTIMA-ATACANTE */
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (20.15, 6, 1, 1);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (15.75, 5, 2, 2);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (20.45, 3, 3, 3);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (25.20, 7, 4, 4);
INSERT INTO relacion_va (distancia, tiempo, id_usuario_atacante, id_usuario_victima) VALUES (40.20, 8, 5, 5);

/* Relacion_VA por id:
id 1 = victima lorasmar (1) y el atacante egyorffy0 (2)
id 2 = victima shorsley1 (3) y el atacante lstable2 (4)
id 3 = victima arubury3 (5) y el atacante wgayler4 (6)
id 4 = victima skarpfen5 (7) y el atacante sdand6 (8)
id 5 = victima mtooher7 (9) y el atacante lhowe8 (10)
 */



/* ZONAS_SEGURAS */
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('UCAB', 1);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('SAMBIL',1);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('LA CASONA', 2);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('LA CASCADA',2);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('EL LIDER', 3);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('MILLENIUM',3);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('PARQUE ALI PRIMERA', 4);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('PARQUE DEL ESTE',4);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('UNIVERSIDAD METROPOLITANA', 5);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('RESIDENCIA El CAFETAL',5);
INSERT INTO zona_segura (nombre, id_usuario_victima) VALUES ('SAN IGNACIO',5);



/* COORDENADAS */

/* UCAB */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.464380, -66.978726,1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465496, -66.977413, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465927, -66.975895, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.465469, -66.973420, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.464810, -66.973215, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.463035, -66.976306, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.460823, -66.976544, 1);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.460653, -66.977628, 1);

/* SAMBIL */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.490409041196195, -66.85496445411185,2);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.490178427904944, -66.8532389588693,2);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.488653496625638, -66.8540005376148,2);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.488403205020544, -66.85502749379523,2);

/* LA CASONA */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.369366115403032, -66.98463074895947,3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.369324412448393, -66.98365065841095,3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.369619823521647, -66.98374670541246,3);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.368967456153198, -66.98447828439839,3);

/* LA CASCADA */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.355394165914714, -67.00305103211083,4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.355113163369834, -67.00253873020452,4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.354590735433986, -67.00356333401719,4);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.354400761423328, -67.00315563825927,4);

/* EL LIDER */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.49564931412395, -66.83378426968065,5);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.49545864521016, -66.83236517714514,5);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.49464396761806, -66.83240924834189,5);

/* MILLENIUM */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.48572374873185, -66.82175947804225,6);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.484979032045441, -66.820569335339,6);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.486953118389607, -66.82129063394703,6);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.486728522374337, -66.82011251288723,6);

/* PARQUE ALI PRIMERA */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.516028801013462, -66.94159364224325,7);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.514769885535909, -66.93806278996723,7);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.51246186049311, -66.93812099082892,7);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.514483767665878, -66.94182644569003,7);

/* PARQUE DEL ESTE */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.496659604820438, -66.84305498171973,8);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.494857233062335, -66.83550394524482,8);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.489207940081359, -66.84239836986562,8);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.488293282948558, -66.83793888093297,8);

/* UNIVERSIDAD METROPOLITANA */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.498666358592782, -66.79835929281191,9);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.496548406512861, -66.78335227123425,9);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.501575609775246, -66.78541159438448,9);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.502622933498136, -66.79727045528419,9);

/* RESIDENCIA EL CAFETAL */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.474157116094633, -66.8509611841993,10);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.470500251806412, -66.8532389588693,10);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.472879723198247, -66.8540005376148,10);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.477087585785457, -66.84179151772653,10);

/* SAN IGNACIO */
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.49838325431059, -66.85772633534465,11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.49837730379655, -66.85548664358359,11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.497945016324731, -66.85548337089182,11);
INSERT INTO coordenadas (latitud, longitud, id_zona_segura) VALUES (10.497500915716433, -66.85728260833602,11);


/* HISTORICO_USUARIO */

/* HISTORICO DE VICTIMA */
/*DENTRO DE ZONA SEGURA UCAB */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.464880831054405, -66.97593507613092, 1);
/* FUERA DE ZONA SEGURA UCAB */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.466625501478564, -66.97069264154554, 1);
/*DENTRO DE ZONA SEGURA SAMBIL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.48868604458184, -66.85434168654625, 1);
/* FUERA DE ZONA SEGURA SAMBIL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.49024108346602, -66.85116108107948, 1);
/*DENTRO DE ZONA SEGURA LA CASONA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.36929031056443, -66.98376658932597, 3);
/* FUERA DE ZONA SEGURA LA CASONA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.369392940741873, -66.98087653281883, 3);
/*DENTRO DE ZONA SEGURA LA CASCADA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.354601309353043, -67.00274790364904, 3);
/* FUERA DE ZONA SEGURA LA CASCADA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.3529020933373, -67.00471128058851, 3);
/*DENTRO DE ZONA SEGURA EL LIDER */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.485977334501142, -66.82152708297072, 5);
/* FUERA DE ZONA SEGURA EL LIDER */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.48428026347308, -66.82009875980407, 5);
/*DENTRO DE ZONA SEGURA MILLENIUM */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.495066770651366, -66.83269181955394, 5);
/* FUERA DE ZONA SEGURA MILLENIUM */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.494412679633022, -66.83488053435511, 5);
/*DENTRO DE ZONA SEGURA PARQUE ALI PRIMERA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.513526567161593, -66.93869638570926, 7);
/* FUERA DE ZONA SEGURA PARQUE ALI PRIMERA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.513041325723503, -66.94307375068907, 7);
/*DENTRO DE ZONA SEGURA PARQUE DEL ESTE */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.494627206723939, -66.8369078696001, 7);
/* FUERA DE ZONA SEGURA PARQUE DEL ESTE */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.493510594327793, -66.84740091677028, 7);
/*DENTRO DE ZONA SEGURA UNIVERSIDAD METROPOLITANA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.502100616969383, -66.79443302979595, 9);
/* FUERA DE ZONA SEGURA UNIVERSIDAD METROPOLITANA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.49556556033813, -66.79817719480653, 9);
/*DENTRO DE ZONA SEGURA RESIDENCIA EL CAFETAL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.47377680885165, -66.84875617799231, 9);
/* FUERA DE ZONA SEGURA RESIDENCIA EL CAFETAL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.47662779651508, -66.83587175458226, 9);
/*DENTRO DE ZONA SEGURA SAN IGNACIO */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.4981537700983, -66.85593152749638, 9);
/* FUERA DE ZONA SEGURA SAN IGNACIO */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.498660133371601, -66.85345316644164, 9);



/* HISTORICO DE ATACANTE */

/*DENTRO DE ZONA SEGURA UCAB */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.464261752093504, -66.97711405159444, 2);
/* FUERA DE ZONA SEGURA UCAB */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.465297301660232, -66.98004432070768, 2);
/*DENTRO DE ZONA SEGURA SAMBIL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.489516569573443, -66.85424630490584, 2);
/* FUERA DE ZONA SEGURA SAMBIL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.490932003996855, -66.8557033538456, 2);
/*DENTRO DE ZONA SEGURA LA CASONA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.36930949768679, -66.98412228504117, 4);
/* FUERA DE ZONA SEGURA LA CASONA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.369646562060044, -66.98409928766667, 4);
/*DENTRO DE ZONA SEGURA LA CASCADA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.355065669954808, -67.00282304435527, 4);
/* FUERA DE ZONA SEGURA LA CASCADA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.353725297339995, -67.00208811910744, 4);
/*DENTRO DE ZONA SEGURA EL LIDER */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.485782853154047, -66.82111030929502, 6);
/* FUERA DE ZONA SEGURA EL LIDER */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.486184762925653, -66.82305781553673, 6);
/*DENTRO DE ZONA SEGURA MILLENIUM */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.495562646450441, -66.83328185803764, 6);
/* FUERA DE ZONA SEGURA MILLENIUM */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.497147861701203, -66.83636046570425, 6);
/*DENTRO DE ZONA SEGURA PARQUE ALI PRIMERA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.514159500425944, -66.94008041983923, 8);
/* FUERA DE ZONA SEGURA PARQUE ALI PRIMERA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.51763104964953, -66.94543489911497, 8);
/*DENTRO DE ZONA SEGURA PARQUE DEL ESTE */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.492274711915035, -66.83952569294581, 8);
/* FUERA DE ZONA SEGURA PARQUE DEL ESTE */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.49337557411075, -66.84823136912584, 8);
/*DENTRO DE ZONA SEGURA UNIVERSIDAD METROPOLITANA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.499969706507821, -66.79170791574042, 10);
/* FUERA DE ZONA SEGURA UNIVERSIDAD METROPOLITANA */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.49168232756037, -66.7890774818844, 10);
/*DENTRO DE ZONA SEGURA RESIDENCIA EL CAFETAL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.471877842733102, -66.84813387037019, 10);
/* FUERA DE ZONA SEGURA RESIDENCIA EL CAFETAL */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.478690386955629, -66.84386937944672, 10);
/*DENTRO DE ZONA SEGURA SAN IGNACIO */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.497879493324278, -66.85677911802242, 10);
/* FUERA DE ZONA SEGURA SAN IGNACIO */
INSERT INTO historico_usuario (estadoConexion, fecha, latitud, longitud, id_usuario)
VALUES (1, '2023-12-02 10:00:00',10.495586179537106, -66.85604609536063, 10);


/* QUERY ULTIMO INSERT DE HISTORICO DE VICTIMA Y ATACANTE */
SELECT hu.* FROM historico_usuario hu INNER JOIN ((SELECT MAX(hu.id) AS ultimo_registro, 'usuario_victima' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_victima WHERE rva.id = 1 GROUP BY entidad) UNION (SELECT MAX(hu.id) AS ultimo_registro, 'usuario_atacante' AS entidad FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = 1 GROUP BY entidad)) ult ON hu.id = ult.ultimo_registro;

/* QUERY DEL ULTIMO HISTORICO DEL ATACANTE */
SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_atacante ua ON u.id = ua.id_usuario INNER JOIN relacion_VA rva ON ua.id = rva.id_usuario_atacante WHERE rva.id = 1 ORDER BY hu.id DESC LIMIT 1;

/* QUERY DEL ULTIMO HISTORICO DE LA VICTIMA */
SELECT hu.* FROM historico_usuario hu INNER JOIN usuario u ON hu.id_usuario = u.id INNER JOIN usuario_victima uv ON u.id = uv.id_usuario INNER JOIN relacion_VA rva ON uv.id = rva.id_usuario_atacante WHERE rva.id = 1 ORDER BY hu.id DESC LIMIT 1;
