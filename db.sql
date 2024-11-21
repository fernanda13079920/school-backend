
CREATE TYPE estado_enum AS ENUM ('Abierta', 'Cerrada', 'Vacaciones de Fin de año', 'Vacaciones de invierno');
CREATE TYPE genero_enum AS ENUM ('Masculino', 'Femenino');
CREATE TYPE estado_enum_b AS ENUM ('Muy Bien', 'Bien', 'Mal', 'No'); 

CREATE TABLE funcion (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE formacion (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE financiamiento (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
-- *************************
CREATE TABLE idioma (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE rol (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE privilegio (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE rol_privilegio (
    id_rol INT REFERENCES rol(id),
    id_privilegio INT REFERENCES privilegio(id),
    PRIMARY KEY (id_rol, id_privilegio)
);
CREATE TABLE colegio (
	codigo INT,
    area varchar,
    canton varchar,
    ciudad varchar,    
    codigo_distrito INT,
    departamento VARCHAR,
    descripcion TEXT,
    direccion VARCHAR,
    distrito varchar,
    estado estado_enum,
    nombre VARCHAR,
    provincia varchar,
    seccion_municipal varchar,
    turno varchar,
    zona varchar,	
    PRIMARY KEY (codigo)
);

CREATE TABLE personal (
    carnet INT PRIMARY KEY NOT NULL,
    id_financiamiento INT NOT NULL,
    id_funcion INT NOT NULL,
    id_formacion INT NOT NULL,
    codigo_colegio INT REFERENCES colegio(codigo),
    apellido_materno VARCHAR NOT NULL,
    apellido_paterno VARCHAR NOT NULL,
    braile BOOLEAN DEFAULT FALSE,
    complemento VARCHAR,
    correo VARCHAR NOT NULL,
    denominativo VARCHAR NOT NULL,
    direccion_domiciliaria VARCHAR NOT NULL,
    extranjero BOOLEAN default FALSE,
    fecha_nacimiento DATE NOT NULL,
    genero genero_enum,    
    nombres VARCHAR NOT NULL,
    normalista BOOLEAN default FALSE,
    nro_celular INT NOT NULL,
    nro_item INT NOT NULL,
    rda INT NOT NULL
);


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    id_rol INT references rol(id),
    username VARCHAR,
    password VARCHAR
);


CREATE TABLE persona_idioma (
    id_personal INT REFERENCES personal(carnet),
    id_idioma INT REFERENCES idioma(id),
    estado_escribe estado_enum_b NOT NULL,
    estado_habla estado_enum_b NOT NULL,
    estado_lee estado_enum_b NOT null,
    PRIMARY KEY (id_personal, id_idioma)
);

CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR
);

CREATE TABLE paralelo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR
);

CREATE TABLE curso_paralelo (
    id_curso INT REFERENCES curso(id),
    id_paralelo INT REFERENCES paralelo(id),
    PRIMARY KEY (id_curso, id_paralelo)
);


-- *************
CREATE TABLE edificio (
    id SERIAL PRIMARY KEY,
    codigo_colegio INT references colegio(codigo),
    descripcion TEXT,
    nombre VARCHAR
);
CREATE TABLE espacio (
    id SERIAL PRIMARY KEY,
    descripcion TEXT,
    codigo_colegio INT REFERENCES colegio(codigo),
    id_edificio INT REFERENCES edificio(id),
    nombre VARCHAR,
    ubicacion VARCHAR
);


CREATE TABLE aula (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR
);

CREATE TABLE aula_edificio (
    id_aula INT REFERENCES aula(id),
    id_edificio INT REFERENCES edificio(id),
    PRIMARY KEY (id_aula, id_edificio)
);

CREATE TABLE nivel (
    id SERIAL PRIMARY KEY,
    codigo_colegio INT REFERENCES colegio(codigo),
    detalle TEXT,
    nombre VARCHAR
);
CREATE TABLE nivel_curso (
    id_nivel INT REFERENCES nivel(id),
    id_curso INT REFERENCES curso(id),
    PRIMARY KEY (id_nivel, id_curso)
);
CREATE TABLE area (
    id SERIAL PRIMARY KEY,
    detalle TEXT,
    nombre VARCHAR
);

CREATE TABLE area_nivel (
    id SERIAL PRIMARY KEY,
    id_area INT REFERENCES area(id),
    id_nivel INT REFERENCES nivel(id)
);


