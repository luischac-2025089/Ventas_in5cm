drop database if exists DB_Ventas_in5cm;
create database DB_Ventas_in5cm;
use DB_Ventas_in5cm;

create table Usuarios (
	codigo_usuario int primary key not null auto_increment,
    username varchar (45) not null,
    pasword varchar (45) not null,
    email varchar (60) not null,
    rol varchar (45) not null,
    estado int not null
);

create table Clientes (
	dpi_cliente int primary key not null auto_increment,
    nombre_cliente varchar (50) not null,
    apellido_cliente varchar (50) not null,
    direccion varchar (100) not null,
    estado int not null
);

create table Productos (
	codigo_producto int not null primary key auto_increment,
    nombre_producto varchar (60) not null,
    precio decimal (10,2) not null,
    stock int not null,
    estado int not null
);

create table Ventas (
	codigo_venta int primary key not null auto_increment,
    fecha_venta date not null,
    total decimal (10,2) not null,
	estado int not null,
    clientes_dpi_cliente int not null,
    usuarios_codigo_usuario int not null,
    foreign key (clientes_dpi_cliente) references Clientes (dpi_cliente) on delete cascade,
    foreign key (usuarios_codigo_usuario) references Usuarios (codigo_usuario) on delete cascade
);

create table DetalleVenta (
	codigo_detalle_venta int primary key not null auto_increment,
    cantidad int not null,
    precio_unitario decimal (10,2) not null,
    subtotal decimal (10,2) not null,
    productos_codigo_producto int not null,
    ventas_codigo_venta int not null,
    foreign key (productos_codigo_producto) references Productos (codigo_producto) on delete cascade,
    foreign key (ventas_codigo_venta) references Ventas (codigo_venta) on delete cascade
);

  -- --------------- PROCEDIMIENTOS ALMACENADOS ------------------- --
  
  -- ---------------- USUARIOS ---------------------- --
  Delimiter $$
  create procedure sp_Usuarios_create (
							p_username varchar (45),
							p_pasword varchar (45),
							p_email varchar (60),
							p_rol varchar (45),
							p_estado int)
	begin
		insert into Usuarios (username, pasword, email, rol, estado)
							values (p_username, p_pasword, p_email, p_rol, p_estado);
    end$$
  Delimiter ;
  
  Delimiter $$
	create procedure sp_Usuarios_read_all ()
	begin
		select * from Usuarios order by codigo_usuario;
    end$$

  Delimiter ;
  
  delimiter $$
  create procedure sp_Usuarios_update(
    p_codigo_usuario int,
    p_username varchar(45),
    p_pasword varchar(45),
    p_email varchar(60),
    p_rol varchar(45),
    p_estado int
)
begin
    update Usuarios 
    set username = p_username, 
        pasword = p_pasword, 
        email = p_email,
        rol = p_rol, 
        estado = p_estado
    where codigo_usuario = p_codigo_usuario;
end$$
delimiter ;

delimiter $$
create procedure sp_Usuarios_buscar(in p_codigo int)
begin 
	select * from Usuarios where codigo_usuario = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_Usuarios_delete(
    p_codigo_usuario int
)
begin
    delete from Usuarios where codigo_usuario = p_codigo_usuario;
end$$
delimiter ;

-- ----------- CLIENTES  ------------------ --

  Delimiter $$
  create procedure sp_Clientes_create (
							p_nombre_cliente varchar (50),
							p_apellido_cliente varchar (50),
							p_direccion varchar (100),
							p_estado int)
	begin
		insert into Clientes (nombre_cliente, apellido_cliente, direccion, estado)
							values (p_nombre_cliente, p_apellido_cliente, p_direccion, p_estado);
    end$$
  Delimiter ;
  
  Delimiter $$
	create procedure sp_Clientes_read_all ()
	begin
		select * from Clientes order by dpi_cliente;
    end$$
  Delimiter ;
  
  delimiter $$
  create procedure sp_Clientes_update(
    p_dpi_cliente int,
    p_nombre_cliente varchar(50),
    p_apellido_cliente varchar(50),
    p_direccion varchar(100),
    p_estado int
)
begin
    update Clientes 
    set nombre_cliente = p_nombre_cliente, 
        apellido_cliente = p_apellido_cliente, 
        direccion = p_direccion,
        estado = p_estado
    where codigo_usuario = p_codigo_usuario;
end$$
delimiter ;

delimiter $$
create procedure sp_Clientes_buscar(in p_dpi int)
begin 
	select * from Clientes where dpi_cliente = p_dpi;
end$$
delimiter ;

delimiter $$
create procedure sp_Clientes_delete(
    p_dpi_cliente int
)
begin
    delete from Clientes where dpi_cliente = p_dpi_cliente;
end$$
delimiter ;

-- ---------PRODUCTOS ------------- --

  Delimiter $$
  create procedure sp_Productos_create (
							p_nombre_producto varchar (60),
							p_precio decimal (10,2),
							p_stock int,
							p_estado int)
	begin
		insert into Productos (nombre_producto, precio, stock, estado)
							values (p_nombre_producto, p_precio, p_stock, p_estado);
    end$$
  Delimiter ;
  
  Delimiter $$
	create procedure sp_Productos_read_all ()
	begin
		select * from Productos order by codigo_producto;
    end$$
  Delimiter ;
  
  delimiter $$
  create procedure sp_Productos_update(
    p_codigo_producto int,
    p_nombre_producto varchar(60),
    p_precio decimal (10,2),
    p_stock int,
    p_estado int
)
begin
    update Productos 
    set nombre_producto = p_nombre_producto, 
        precio = p_precio, 
        stock = p_stock,
        estado = p_estado
    where codigo_producto = p_codigo_producto;
end$$
delimiter ;

delimiter $$
create procedure sp_Productos_buscar(in p_codigo int)
begin 
	select * from Productos where codigo_producto = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_Productos_delete(
    p_codigo_producto int
)
begin
    delete from Productos where codigo_producto = p_codigo_producto;
end$$
delimiter ;

-- ----------VENTAS----------------- --

  Delimiter $$
  create procedure sp_Ventas_create (
							p_fecha_venta date,
							p_total decimal (10,2),
							p_estado int,
                            p_clientes_dpi_cliente int,
                            p_usuarios_codigo_usuario int)
	begin
		insert into Ventas (fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario)
							values (p_fecha_venta, p_total, p_estado, p_clientes_dpi_cliente, p_usuarios_codigo_usuario);
    end$$
  Delimiter ;
  
  Delimiter $$
	create procedure sp_Ventas_read_all ()
	begin
		select * from Ventas order by codigo_venta;
    end$$
  Delimiter ;
  
  delimiter $$
  create procedure sp_Ventas_update(
    p_codigo_venta int,
    p_fecha_venta date,
    p_total decimal (10,2),
    p_estado int,
    p_clientes_dpi_cliente int,
    p_usuarios_codigo_usuario int
)
begin
    update Ventas 
    set fecha_venta = p_fecha_venta, 
        total = p_total, 
        estado = p_estado,
        clientes_dpi_cliente = p_clientes_dpi_cliente,
        usuarios_codigo_usuario = p_usuarios_codigo_usuario
    where codigo_venta = p_codigo_venta;
end$$
delimiter ;

delimiter $$
create procedure sp_Ventas_buscar(in p_codigo int)
begin 
	select * from Ventas where codigo_venta = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_Ventas_delete(
    p_codigo_venta int
)
begin
    delete from Ventas where codigo_venta = p_codigo_venta;
end$$
delimiter ;

-- ----------DETALLE VENTA------------ --

  Delimiter $$
  create procedure sp_DetalleVenta_create (
							p_cantidad int,
							p_precio_unitario decimal (10,2),
							p_subtotal decimal (10,2),
                            p_productos_codigo_producto int,
                            p_ventas_codigo_venta int)
	begin
		insert into DetalleVenta (cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
							values (p_cantidad, p_precio_unitario, p_subtotal, p_productos_codigo_producto, p_ventas_codigo_venta);
    end$$
  Delimiter ;
  
  Delimiter $$
	create procedure sp_DetalleVenta_read_all ()
	begin
		select * from DetalleVenta order by codigo_detalle_venta;
    end$$
  Delimiter ;
  
  delimiter $$
  create procedure sp_DetalleVenta_update(
    p_codigo_detalle_venta int,
    p_cantidad int,
    p_precio_unitario decimal (10,2),
    p_subtotal decimal (10,2),
    p_productos_codigo_producto int,
    p_ventas_codigo_venta int
)
begin
    update DetalleVenta 
    set cantidad = p_cantidad, 
        precio_unitario = p_precio_unitario, 
        subtotal = p_subtotal,
        productos_codigo_producto = p_productos_codigo_producto,
        ventas_codigo_venta = p_ventas_codigo_venta
    where codigo_detalle_venta = p_codigo_detalle_venta;
end$$
delimiter ;

delimiter $$
create procedure sp_DetalleVenta_buscar(in p_codigo int)
begin 
	select * from DetalleVenta where codigo_detalle_venta = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_DetalleVenta_delete(
    p_codigo_detalle_venta int
)
begin
    delete from DetalleVenta where codigo_detalle_venta = p_codigo_detalle_venta;
end$$
delimiter ;

call sp_Usuarios_create ('admin', 'admin123', 'admin@gmail.com', 'administrador', 1);
call sp_Usuarios_create ('juanp', 'jp123', 'juan@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('mariaa', 'ma456', 'maria@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('carloss', 'cs789', 'carlos@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('sofiar', 'sr321', 'sofia@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('luisg', 'lg654', 'luis@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('andream', 'am987', 'andrea@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('pedroh', 'ph741', 'pedro@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('daniell', 'dl852', 'daniel@gmail.com', 'vendedor', 1);
call sp_Usuarios_create ('valeriar', 'vr963', 'valeria@gmail.com', 'vendedor', 1);

call sp_Clientes_create ('Juan', 'Perez', 'Zona 1 Guatemala', 1);
call sp_Clientes_create ('Maria', 'Lopez', 'Zona 2 Guatemala', 1);
call sp_Clientes_create ('Carlos', 'Ramirez', 'Zona 3 Guatemala', 1);
call sp_Clientes_create ('Ana', 'Gomez', 'Zona 4 Guatemala', 1);
call sp_Clientes_create ('Luis', 'Castillo', 'Zona 5 Guatemala', 1);
call sp_Clientes_create ('Sofia', 'Morales', 'Zona 6 Guatemala', 1);
call sp_Clientes_create ('Pedro', 'Hernandez', 'Zona 7 Guatemala', 1);
call sp_Clientes_create ('Andrea', 'Mendez', 'Zona 8 Guatemala', 1);
call sp_Clientes_create ('Daniel', 'Garcia', 'Zona 9 Guatemala', 1);
call sp_Clientes_create ('Valeria', 'Rojas', 'Zona 10 Guatemala', 1);

call sp_Productos_create ('Laptop', 5500.00, 10, 1);
call sp_Productos_create ('Mouse', 75.00, 50, 1);
call sp_Productos_create ('Teclado', 150.00, 40, 1);
call sp_Productos_create ('Monitor', 1200.00, 15, 1);
call sp_Productos_create ('Audifonos', 300.00, 25, 1);
call sp_Productos_create ('USB 32GB', 80.00, 60, 1);
call sp_Productos_create ('Disco Duro 1TB', 600.00, 20, 1);
call sp_Productos_create ('Webcam', 250.00, 18, 1);
call sp_Productos_create ('Microfono', 350.00, 12, 1);
call sp_Productos_create ('Base para Laptop', 120.00, 30, 1);

call sp_Ventas_create ('2026-03-01', 5750.00, 1, 1, 1);
call sp_Ventas_create ('2026-03-02', 150.00, 1, 2, 2);
call sp_Ventas_create ('2026-03-03', 300.00, 1, 3, 3);
call sp_Ventas_create ('2026-03-04', 1200.00, 1, 4, 4);
call sp_Ventas_create ('2026-03-05', 380.00, 1, 5, 5);
call sp_Ventas_create ('2026-03-06', 80.00, 1, 6, 6);
call sp_Ventas_create ('2026-03-07', 600.00, 1, 7, 7);
call sp_Ventas_create ('2026-03-08', 250.00, 1, 8, 8);
call sp_Ventas_create ('2026-03-09', 350.00, 1, 9, 9);
call sp_Ventas_create ('2026-03-10', 120.00, 1, 10, 10);

call sp_DetalleVenta_create (1, 5500.00, 5500.00, 1, 1);
call sp_DetalleVenta_create (2, 75.00, 150.00, 2, 2);
call sp_DetalleVenta_create (2, 150.00, 300.00, 3, 3);
call sp_DetalleVenta_create (1, 1200.00, 1200.00, 4, 4);
call sp_DetalleVenta_create (1, 300.00, 300.00, 5, 5);
call sp_DetalleVenta_create (1, 80.00, 80.00, 6, 6);
call sp_DetalleVenta_create (1, 600.00, 600.00, 7, 7);
call sp_DetalleVenta_create (1, 250.00, 250.00, 8, 8);
call sp_DetalleVenta_create (1, 350.00, 350.00, 9, 9);
call sp_DetalleVenta_create (1, 120.00, 120.00, 10, 10);