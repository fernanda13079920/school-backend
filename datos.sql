
insert into rol (nombre,descripcion)values('Administrador general', 'usuario con el máximo control del sistema');
insert into rol (nombre,descripcion)values('Administrador', 'administra las funcionalidades de servicio e inventario');
insert into rol (nombre,descripcion)values('Recepcionista', 'tiene acceso a funcionalidades básicas de atención al cliente');

insert into privilegio (nombre,descripcion) values('adm.usuario','Permite controlar los aspectos relacionados con los usuarios.');
insert into privilegio (nombre,descripcion) values('adm.servicio','Permite controlar los aspectos relacionados con los servicios.');
insert into privilegio (nombre,descripcion) values('adm.inventario','Permite controlar los aspectos relacionados con el inventario.');

insert into rol_privilegio(id_rol,id_privilegio) values (1,1);
insert into rol_privilegio(id_rol,id_privilegio) values(1,2);

INSERT INTO financiamiento (descripcion,nombre)VALUES ('descripcion','nombre financiamiento1');
INSERT INTO financiamiento (descripcion,nombre)VALUES ('descripcion','nombre financiamiento2');
INSERT INTO financiamiento (descripcion,nombre)VALUES ('descripcion','nombre financiamiento3');
INSERT INTO financiamiento (descripcion,nombre)VALUES ('descripcion','nombre financiamiento4');

INSERT INTO formacion (descripcion,nombre)VALUES ('descripcion','nombre formacion1');
INSERT INTO formacion (descripcion,nombre)VALUES ('descripcion','nombre formacion2');
INSERT INTO formacion (descripcion,nombre)VALUES ('descripcion','nombre formacion3');
INSERT INTO formacion (descripcion,nombre)VALUES ('descripcion','nombre formacion4');

INSERT INTO funcion (descripcion,nombre)VALUES ('descripcion','nombre funcion1');
INSERT INTO funcion (descripcion,nombre)VALUES ('descripcion','nombre funcion2');
INSERT INTO funcion (descripcion,nombre)VALUES ('descripcion','nombre funcion3');
INSERT INTO funcion (descripcion,nombre)VALUES ('descripcion','nombre funcion4');

INSERT INTO idioma (descripcion,nombre)VALUES ('descripcion','español');
INSERT INTO idioma (descripcion,nombre)VALUES ('descripcion','ingles');
INSERT INTO idioma (descripcion,nombre)VALUES ('descripcion','japonés');
INSERT INTO idioma (descripcion,nombre)VALUES ('descripcion','chino');

INSERT INTO colegio (codigo,area,canton,ciudad,codigo_distrito,departamento,descripcion,direccion,distrito,estado,nombre,provincia,seccion_municipal,turno,zona)
VALUES (100001,'area1','canton1','santa cruz',1002,'santa cruz','descripcion','AV los palotes','MZ-25','Abierta','Elvira Parada','andrez ibanes','SEC-10','Mañana','Zona plan 3000');
INSERT INTO colegio (codigo,area,canton,ciudad,codigo_distrito,departamento,descripcion,direccion,distrito,estado,nombre,provincia,seccion_municipal,turno,zona)
VALUES (100002,'area1','canton1','santa cruz',1002,'santa cruz','descripcion','AV los palotes','MZ-25','Abierta','Elvira Parada','andrez ibanes','SEC-10','Mañana','Zona plan 3000');

-- registrar persona por Postman

insert into aula (nombre) values ('Aula 1');
insert into aula (nombre) values ('Aula 2');
insert into aula (nombre) values ('Aula 3');
insert into aula (nombre) values ('Aula 4');
insert into aula (nombre) values ('Aula 5');

insert into edificio (codigo_colegio,nombre, descripcion) values (100002,'Es un edificio grande', 'FICCT');
insert into edificio (codigo_colegio,nombre, descripcion) values (100002,'Es un edificio chico', 'Medicina');

insert into espacio (descripcion, codigo_colegio,nombre, id_edificio,ubicacion) values ('es una parque',100002,1,'AV azul');
insert into espacio (descripcion,nombre, id_edificio,ubicacion) values ('es un lote','juancho',1,'AV rojo');


select * from espacio e 

select * from aula_edificio ae 

select * from edificio e 

select * from aula a 

select * from personal p 

select * from users u 

select * from rol r 

select * from rol_privilegio rp 

select * from idioma 

select * from persona_idioma pi2 

select * from colegio c 
	

