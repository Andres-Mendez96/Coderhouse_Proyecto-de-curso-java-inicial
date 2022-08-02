insert into CLIENTES (NOMBRE, APELLIDO, DNI, ID_CLIENTE)
values
('Juan', 'Perez', 10010010, 1122),
('Pedro','Ramirez', 10010020, 2233),
('Elizabeth', 'Mendoza', 10010030, 3344),
('Erika', 'Montenegro', 10010040, 4455);

insert into PRODUCTOS (CODIGO, DESCRIPCION, PRECIO, STOCK_DISPONIBLE)
values
(20020010, 'Atún en lomitos x 200gr', 400, 100),
(20020020, 'Arvejas remojadas x 350gr', 50, 100),
(20020030, 'Granos de choclo amarillo x 800gr', 440, 100 ),
(20020040, 'Frijoles Bayos Refritos x 400gr', 850, 100),
(20020050, 'Pepino agridulce x 600gr', 770, 100);

insert into LINEA_DE_VENTA (ID_VENTA, CODIGO, DESCRIPCION, PRECIO, CANTIDAD, ID_COMPROBANTE)
values
(1, 20020010, 'Atun en lomitos x 200gr', 400, 5, 1234);

