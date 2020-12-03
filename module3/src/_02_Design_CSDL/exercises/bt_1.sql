create database bt_1;
use bt_1;
create table Customers(
customer_number int not null primary key,
fullname varchar(50),
address varchar(100),
email varchar(100),
phone varchar(50)
);

create table Accounts(
account_number int not null primary key,
account_type varchar(50),
account_date date,
balance varchar(1000),
customer_number int,
foreign key (customer_number) references Customers(customer_number)
);

create table Transactions(
tran_number int not null primary key,
account_number int,
tran_date datetime,
tran_amount varchar(1000),
`description` varchar(1000),
foreign key (account_number) references Accounts(account_number)
);