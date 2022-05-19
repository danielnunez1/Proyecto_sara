CREATE TABLE usuario (
    id int(10) NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    empresa varchar(100) NOT NULL,
    usuario varchar(100) NOT NULL,
    clave varchar(512) NOT NULL,
    roles varchar(255) NOT NULL,
    estado varchar(50) NOT NULL,
    PRIMARY KEY(id)
);
