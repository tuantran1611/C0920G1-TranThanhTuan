create database bt_1_function;
use bt_1_function;

create table HocVien(
Id int not null primary key,
TenHV varchar(45),
TuoiHV int,
KhoaHoc varchar(45),
SoTien int 
);

insert into HocVien
values
(1, 'Hoang',21,'CNTT',400000),
(2, 'Viet',19,'DTVT',320000),
(3, 'Thanh',18,'KTDN',400000),
(4, 'Nhan',19,'CK',450000),
(5, 'Huong',20,'TCNH',500000),
(6, 'Huong',20,'TCNH',200000);

select TenHV , sum(SoTien) as TongSoTien from HocVien where TenHV = 'Huong' group by TenHV;

select distinct TenHV, TuoiHV from HocVien;