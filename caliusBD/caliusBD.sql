
create database if not exists calius;
use calius;

create table alumnos(
	a_matricula varchar(10),
    a_nombre varchar(30),
    a_ap varchar(30),
    a_am varchar (30),
    a_lic varchar (10),
    a_grupo varchar (5),
    a_sem int,
    a_periodo varchar (6),
primary key(a_matricula));

create table calificaciones(
	c_matricula varchar(10),
    c_id_materia varchar(10),
    c_periodo varchar(6),
    c_parcial1 float,
    c_parcial2 float,
    c_parcial3 float,
    c_proparcial float,
    c_ordinario float,
    c_final float,
    c_extra1 float,
    c_extra2 float,
    c_especial float,
primary key(c_matricula, c_id_materia, c_periodo));

create table materias(
	id_materia varchar(10),
    m_nombre varchar(30),
    m_lic varchar(10),
    m_sem int,
primary key(id_materia, m_lic));

create table usuarios(
	id_usuario varchar(10),
    u_password varchar(45),
primary key (id_usuario));

create table notificaciones(
	id_notificacion int auto_increment,
    n_remitente varchar(10),
    n_destinatario varchar(20),
    n_mensaje  longtext,
    n_fecha date,
    n_asunto varchar(255),
primary key(id_notificacion));


alter table usuarios add foreign key (id_usuario) references  alumnos(a_matricula) on delete cascade;
alter table notificaciones add foreign key (n_remitente) references  usuarios(id_usuario) on delete cascade;
alter table calificaciones add foreign key (c_matricula) references  alumnos(a_matricula) on delete cascade;
alter table calificaciones add foreign key (c_id_materia) references  materias(id_materia) on delete cascade;


    