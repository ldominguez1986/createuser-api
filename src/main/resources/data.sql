
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