drop database if exists calius;
create database if not exists calius;
use calius;

drop table if exists alumnos;
create table alumnos(
	alumnoMatricula varchar(10),
    alumnoNombre varchar(30),
    alumnoAp varchar(30),
    alumnoAm varchar (30),
    alumnoLic varchar (10),
    alumnoGrupo varchar (5),
    alumnoSem int,
    alumnoPeriodo varchar (6),
primary key(alumnoMatricula));

drop table if exists calificaciones;
create table calificaciones(
	cAlumnoMatricula varchar(10),
    cMateriaId varchar(10),
    cPeriodo varchar(6),
    cParcial1 float,
    cParcial2 float,
    cParcial3 float,
    cOrdinario float,
    cFinal float,
    cExtra1 float,
    cExtra2 float,
    cEspecial float,
primary key(cAlumnoMatricula, cMateriaId, cPeriodo));

drop table if exists materias;
create table materias(
	materiaId varchar(10),
    materiaNombre varchar(30),
    materiaLic varchar(10),
    materiaSem int,
primary key(materiaId, materiaLic));

drop table if exists usuarios;
create table usuarios(
	usuarioId varchar(10),
	usuarioTelefono varchar(10),
	usuarioIdGcm varchar(255),
    usuarioPassword varchar(45),
    usuarioTipo int,
primary key (usuarioId));

drop table if exists notificaciones;
create table notificaciones(
	notifId int auto_increment,
    notifRemitente varchar(10),
    notifDstinatario varchar(20),
    notifMensaje  longtext,
    notifFecha date,
    notifAsunto varchar(255),
primary key(notifId));

drop table if exists administrativos;
create table administrativos(
	adminId varchar(10),
    adminNombre varchar (150),
    adminPuesto varchar (30),
primary key (adminId));

drop table if exists usuariosTemp;
create table usuariosTemp(
	usuarioId varchar(10),
	usuarioTelefono varchar(10),
    usuarioCodigo varchar(10),
primary key (usuarioId));

-- alter table usuarios add foreign key (usuarioId) references  alumnos(alumnoMatricula) on delete cascade;
-- alter table usuarios add foreign key (usuarioId) references  administrativos(adminId) on delete cascade;
alter table notificaciones add foreign key (notifRemitente) references  usuarios(usuarioId) on delete cascade;
alter table calificaciones add foreign key (cAlumnoMatricula) references  alumnos(alumnoMatricula) on delete cascade;
alter table calificaciones add foreign key (cMateriaId) references  materias(materiaId) on delete cascade;


-- Alta Alumnos
insert into alumnos values("2013060024", "Benito Alfredo", "Reyes", "Hernandez", "LCI", "806", 8, "2017-A");
insert into alumnos values("2013060012", "Minerva", "Martinez", "Rios", "LCI", "806", 8, "2017-A");

-- Alta Administrativos
insert into Administrativos values("3256", "Gabriela Garcia", "Jefa Servicios Escolares");

-- Alta usuario
insert into usuarios values("2013060024", "9581168329", "APA91bFIS5FRUlV4ahhq2nB5DCJpoCClAJBQJ_cDwOwO0RAx-PHDxsQ2PrZwhHIej-8uhBjP-Rx5g2fzRY9qTUn9J2aQQkJ2AWslbRliDeu4zPBxmMaEXReRvaVdCXumctYH4AQsZ8IeEr_LezrxNjYptI9JYD4MeA", "caliuspass",1);