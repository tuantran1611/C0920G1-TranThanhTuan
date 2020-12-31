create database casestudy3_2;
use casestudy3_2;

CREATE TABLE `position` (
  position_id INT NOT NULL AUTO_INCREMENT,
  position_name VARCHAR(45),
  PRIMARY KEY (position_id));
  
  CREATE TABLE education_degree (
  education_degree_id INT NOT NULL AUTO_INCREMENT,
  education_degree_name VARCHAR(45),
  PRIMARY KEY (education_degree_id));
  
  CREATE TABLE division (
  division_id INT NOT NULL AUTO_INCREMENT,
  division_name VARCHAR(45),
  PRIMARY KEY (division_id));

CREATE TABLE `role` (
  role_id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(45),
  PRIMARY KEY (role_id));
  
  CREATE TABLE `user` (
  username VARCHAR(255) NOT NULL,
  `password` VARCHAR(255),
  PRIMARY KEY (username));

CREATE TABLE user_role (
role_id INT ,
username VARCHAR(255),
foreign key (role_id) references `role`(role_id),
foreign key (username) references `user`(username)
);

CREATE TABLE customer_type (
  customer_type_id INT NOT NULL AUTO_INCREMENT,
  customer_type_name VARCHAR(45) NULL,
  PRIMARY KEY (customer_type_id));

CREATE TABLE customer (
  customer_id INT NOT NULL  AUTO_INCREMENT,
  customer_type_id INT ,
  customer_name VARCHAR(45) ,
  customer_birthday DATE ,
  customer_gender BIT(1) ,
  customer_id_card VARCHAR(45) ,
  customer_phone VARCHAR(45) ,
  customer_email VARCHAR(45) ,
  customer_address VARCHAR(45) ,
  PRIMARY KEY (customer_id),
  constraint cus_1 foreign key (customer_type_id) references customer_type(customer_type_id)
  );

CREATE TABLE employee (
  employee_id INT NOT NULL  AUTO_INCREMENT,
  employee_name VARCHAR(45) ,
  employee_birthday DATE ,
  employee_id_card VARCHAR(45) ,
  employee_salary DOUBLE ,
  employee_phone VARCHAR(45) ,
  employee_email VARCHAR(45) ,
  employee_address VARCHAR(45) ,
  position_id INT ,
  education_degree_id INT ,
  division_id INT ,
  username VARCHAR(255) ,
  PRIMARY KEY (employee_id),
  foreign key (position_id) references `position`(position_id),
  foreign key (education_degree_id) references education_degree(education_degree_id),
  foreign key (division_id) references division(division_id),
  foreign key (username) references `user`(username)
  );
  
CREATE TABLE service_type (
  service_type_id INT NOT NULL AUTO_INCREMENT,
  service_type_name VARCHAR(45),
  PRIMARY KEY (service_type_id));
  
  CREATE TABLE rent_type (
  rent_type_id INT NOT NULL AUTO_INCREMENT,
  rent_type_name VARCHAR(45) NULL,
  rent_type_cost DOUBLE NULL,
  PRIMARY KEY (rent_type_id));
  
  CREATE TABLE service (
  service_id INT NOT NULL AUTO_INCREMENT,
  service_name VARCHAR(45) NULL,
  service_area INT NULL,
  service_type_cost DOUBLE NULL,
  service_max_people INT NULL,
  rent_type_id INT NULL,
  service_type_id INT NULL,
  standard_room VARCHAR(45) NULL,
  description_other_convenience VARCHAR(45) NULL,
  pool_area DOUBLE NULL,
  number_of_floors INT NULL,
  PRIMARY KEY (service_id),
  foreign key (service_type_id) references service_type(service_type_id),
  foreign key (rent_type_id) references rent_type(rent_type_id)
  );
  
  CREATE TABLE attach_service (
  attach_service_id INT NOT NULL AUTO_INCREMENT,
  attach_service_name VARCHAR(45) NULL,
  attach_service_cost DOUBLE NULL,
  attach_service_unit INT NULL,
  attach_service_status VARCHAR(45) NULL,
  PRIMARY KEY (attach_service_id));
  
  CREATE TABLE contract (
  contract_id INT NOT NULL AUTO_INCREMENT,
  contract_start_date DATE NULL,
  contract_end_date DATE NULL,
  contract_deposit DOUBLE NULL,
  contract_total_money DOUBLE NULL,
  employee_id INT,
  customer_id INT,
  service_id INT,
  PRIMARY KEY (contract_id),
  constraint cons_1 foreign key (employee_id) references employee(employee_id),
  constraint cons_2 foreign key (customer_id) references customer(customer_id),
  constraint cons_3 foreign key (service_id) references service(service_id)
  );
  
  CREATE TABLE contract_detail (
  contract_detail_id INT NOT NULL AUTO_INCREMENT,
  contract_id INT NULL,
  attach_service_id INT NULL,
  quantity INT NULL,
  PRIMARY KEY (contract_detail_id),
  constraint consde_1 foreign key (contract_id) references contract(contract_id),
  constraint consde_2 foreign key (attach_service_id) references attach_service(attach_service_id)
  );
  
insert into customer_type values 
(1 ,'Diamond'),(2, 'Platinium'), (3,'Gold'), (4,'Silver'), (5,'Member');
insert into customer values
(1,2,'Tuan', '1995-11-16',1,'231231321','0987575064','tuan@gmail.com','Da Nang');

DELIMITER //
CREATE PROCEDURE search_customer(
in customer_name VARCHAR(45)
)
BEGIN
	SELECT * FROM customer WHERE customer.customer_name LIKE concat('%' ,customer_name,'%') ;
END//
DELIMITER ;
  
  DROP PROCEDURE search_customer;
  
  call search_customer ('Ba');
  
  DELIMITER //
CREATE PROCEDURE search_employee(
in employee_name VARCHAR(45)
)
BEGIN
	SELECT * FROM employee WHERE employee.employee_name LIKE concat('%' ,employee_name,'%') ;
END//
DELIMITER ;

  DELIMITER //
CREATE PROCEDURE search_service(
in service_name VARCHAR(45)
)
BEGIN
	SELECT * FROM service WHERE service.service_name LIKE concat('%' ,service_name,'%') ;
END//
DELIMITER ;

-- DELIMITER //
-- CREATE PROCEDURE search_contract(
-- in customer_id VARCHAR(45)
-- )
-- BEGIN
-- 	SELECT * FROM customer WHERE customer.customer_name LIKE concat('%' ,customer_name,'%') ;
-- END//
-- DELIMITER ;

ALTER TABLE customer
MODIFY COLUMN customer_id int(4) zerofill;

select customer.customer_type_id, customer.customer_name, customer.customer_id_card, customer.customer_phone, customer.customer_address, contract.contract_id, contract.contract_end_date, contract_detail.contract_detail_id, service.service_id, attach_service.attach_service_id from contract
left join customer on customer.customer_id = contract.customer_id
left join service on contract.service_id = service.service_id
left join contract_detail on contract.contract_id = contract_detail.contract_detail_id
left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id 
where contract.contract_end_date < now();

drop database casestudy3_2;
