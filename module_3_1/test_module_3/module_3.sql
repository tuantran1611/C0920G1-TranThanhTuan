create database module3_exam;
use module3_exam;

CREATE TABLE module3_exam.benhan (
  idBenhAn VARCHAR(45) NOT NULL,
  idBenhNhan VARCHAR(45),
  tenBenhNhan VARCHAR(45),
  ngayNhapVien DATE ,
  ngayRaVien DATE ,
  lyDoNhapVien VARCHAR(45) ,
  PRIMARY KEY (idBenhAn),
  constraint key_1 foreign key (idBenhNhan) references benhnhan(idBenhNhan)
  );
  
  CREATE TABLE module3_exam.benhnhan (
  idBenhNhan VARCHAR(45) NOT NULL,
  tenBenhNhan VARCHAR(45) NULL,
  PRIMARY KEY (idBenhNhan));

  
  drop table benhnhan;
  alter table benhan ;
  drop database module3_exam;
