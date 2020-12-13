create database demo;
create table Products(
Id int,
productCode varchar(55),
productName varchar(55),
productPrice varchar(55),
productAmount int,
productDescription varchar(500),
productStatus varchar(100)
);

CREATE UNIQUE INDEX product_code
ON products (productCode);

CREATE INDEX composite_index
 ON products (productName, productPrice);

create view product_info as 
select productCode, productName, productPrice, productStatus 
from products;

create or replace view product_info as
select productCode, productName, productPrice
from products;

drop view product_info;

DELIMITER //

CREATE PROCEDURE findAllProducts()

BEGIN

  SELECT * FROM products;

END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE addNewProducts(
idproduct int, productCode varchar(55),
productName varchar(55),
productPrice varchar(55),
productAmount int,
productDescription varchar(500),
productStatus varchar(100))

BEGIN

	insert into products values
    (idproduct, productCode, productName,productPrice, productAmount, productDescription, productStatus);

END //

DELIMITER ;

