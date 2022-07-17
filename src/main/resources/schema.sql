drop table CLIENTES if exists;

create table CLIENTES (
NOMBRE varchar (200),
APELLIDO varchar (200),
DNI int not null,
ID_CLIENTE int not null,

primary key (ID_CLIENTE)

);