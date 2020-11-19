/* Creacion de Clientes*/

INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (1,'Nahuel','Ovejero','nahuel_ovejero@outlook.es','2019-10-10', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (2,'Jonathan','Perez','Jonathan@outlook.es','2015-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (3,'Oscar','Ovejero','oscar_ovejero@outlook.es','2015-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (4,'Pedro','Perez','pepe@outlook.es','2012-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (5,'Agustin','Rodriguez','agus_ro@outlook.com','2017-01-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (6,'Nicolas','Gonzalez','nico@outlook.es','2012-12-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (7,'Nahuel','Ovejero','nahuel_ovejero@outlook.es','2019-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (8,'Jonathan','Perez','Jonathan@outlook.es','2015-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (9,'Oscar','Ovejero','oscar_ovejero@outlook.es','2015-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (10,'Pedro','Perez','pepe@outlook.es','2012-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (11,'Agustin','Rodriguez','agus_ro@outlook.com','2017-01-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (12,'Nicolas','Gonzalez','nico@outlook.es','2012-12-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (13,'Nahuel','Ovejero','nahuel_ovejero@outlook.es','2019-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (14,'Jonathan','Perez','Jonathan@outlook.es','2015-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (15,'Oscar','Ovejero','oscar_ovejero@outlook.es','2015-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (16,'Pedro','Perez','pepe@outlook.es','2012-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (17,'Agustin','Rodriguez','agus_ro@outlook.com','2017-01-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (18,'Nicolas','Gonzalez','nico@outlook.es','2012-12-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (19,'Nahuel','Ovejero','nahuel_ovejero@outlook.es','2019-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (20,'Jonathan','Perez','Jonathan@outlook.es','2015-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (21,'Oscar','Ovejero','oscar_ovejero@outlook.es','2015-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (22,'Pedro','Perez','pepe@outlook.es','2012-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (23,'Agustin','Rodriguez','agus_ro@outlook.com','2017-01-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (24,'Nicolas','Gonzalez','nico@outlook.es','2012-12-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (25,'Nahuel','Ovejero','nahuel_ovejero@outlook.es','2019-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (26,'Jonathan','Perez','Jonathan@outlook.es','2015-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (27,'Oscar','Ovejero','oscar_ovejero@outlook.es','2015-10-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (28,'Pedro','Perez','pepe@outlook.es','2012-12-12','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (29,'Agustin','Rodriguez','agus_ro@outlook.com','2017-01-10','');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (30,'Nicolas','Gonzalez','nico@outlook.es','2012-12-10','');
 

/* Creacion de Productos */ 

INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Sony',23000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV RCA',22000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Philips',26000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Hitachi',28000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Samsung',33000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Philco',25000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Noblex',24000,NOW());
INSERT INTO productos (nombre,precio,create_at) VALUES ('TV Sanyo',20000,NOW());


/* Creacion de Facturas  */

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipo de hogar', 'Alguna observacion importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2, 1, 2);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3, 2, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 1);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipo de TV', 'SIN GARANTIA', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2, 2, 6);

