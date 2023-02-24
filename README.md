# createuser-api

## Base de datos

Script tabla usuario:

````
CREATE TABLE usuario (
	id UUID NOT NULL,
	name varchar(100)  NOT NULL,
	email varchar(60) NOT NULL,
	password varchar(20) NOT NULL,
	token UUID NOT NULL,
	CONSTRAINT PK_usuario PRIMARY KEY (id),
	CONSTRAINT usuario_UN UNIQUE (email)
);
````

Script tabla telefono:

````
CREATE TABLE telefono (
	id UUID NOT NULL,
	id_usuario UUID NOT NULL,
	number varchar(10) NOT NULL,
	citycode varchar(2) NOT NULL,
	countrycode varchar(2) NOT NULL,
	CONSTRAINT PK_telefono PRIMARY KEY (id)
);
````

## Compile and Build

Ejecutar desde un terminal:

````bash
mvn clean compile package
````

## Test JUnit
Ejecutar desde terminal:

````bash
mvn test
````

## Run
Ejecutar desde terminal:

````bash
mvn spring-boot:run 
````

## Prueba Local
Ejecutar ** curl ** desde un terminal con la siguiente instrucción:

````bash
curl -X 'POST' \
  'http://localhost:8181/api/testjava-v1/usuarios/create' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Luis Dominguez",
  "email": "ldominguez@gmail.com",
  "password": "A123466",
  "phones": [
    {
      "number": "93458950",
      "citycode": "9",
      "countrycode": "56"
    }
  ]
}'
````