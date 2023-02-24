/*CREATE TABLE tal_persona (
	id IDENTITY NOT NULL,
	apellido varchar(60)  NOT NULL,
	nombre varchar(60) NOT NULL,
	edad int NOT NULL,
	rut varchar(10) NOT NULL,
	CONSTRAINT PK__persona PRIMARY KEY (id),
	CONSTRAINT tal_persona_UN UNIQUE (rut)
);

INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Perez', 'Juan', 20, '11193668-4');
INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Acevedo', 'Antonio', 25, '18361496-7');
INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Pedro', 'Morales', 27, '21691026-5');
INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Constanza', 'Lopez', 29, '10817745-4');
INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Francisca', 'Claro', 22, '8001009-5');
INSERT INTO tal_persona (apellido, nombre, edad, rut) VALUES('Dominguez', 'Luis', 36, '16218299-4');*/


--- Usuario

CREATE TABLE usuario (
	id UUID NOT NULL,
	name varchar(100)  NOT NULL,
	email varchar(60) NOT NULL,
	password varchar(20) NOT NULL,
	token UUID NOT NULL,
	CONSTRAINT PK_usuario PRIMARY KEY (id),
	CONSTRAINT usuario_UN UNIQUE (email)
);

-- Telefono
CREATE TABLE telefono (
	id UUID NOT NULL,
	id_usuario UUID NOT NULL,
	number varchar(10) NOT NULL,
	citycode varchar(2) NOT NULL,
	countrycode varchar(2) NOT NULL,
	CONSTRAINT PK_telefono PRIMARY KEY (id)
);