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
CODIGO int not null,
DESCRIPCION varchar (700) not null,
PRECIO float not null,
STOCK_DISPONIBLE int not null,

primary key (CODIGO)
);

drop table VENTA_COMPROBANTE if exists;

create table VENTA_COMPROBANTE (
ID_COMPROBANTE int not null,
ID_CLIENTE int not null,
NOMBRE_COMPLETO varchar (100) not null,
FECHA date not null,
TOTAL float not null,
primary key (ID_COMPROBANTE)

);

drop table LINEA_DE_VENTA if exists;

create table LINEA_DE_VENTA(
ID_VENTA int,
CODIGO int not null,
DESCRIPCION varchar (150) not null,
PRECIO float not null,
CANTIDAD int not null,
ID_COMPROBANTE int not null,
primary key (ID_VENTA)
);