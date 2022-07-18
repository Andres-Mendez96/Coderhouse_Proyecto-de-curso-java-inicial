drop table CLIENTES if exists;

create table CLIENTES (
NOMBRE varchar (200),
APELLIDO varchar (200),
DNI int not null,
ID_CLIENTE int not null,

primary key (ID_CLIENTE)

);

drop table PRODUCTOS if exists;

create table PRODUCTOS (
NOMBRE_PRODUCTO varchar (400) not null,
CODIGO int not null,
DESCRIPCION varchar (700) not null,
PRECIO float not null,
STOCK_DISPONIBLE int not null,

primary key (CODIGO)
);