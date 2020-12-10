create database casestudy3;
use casestudy3;

create table ViTri(
IdViTri int primary key,
tenViTri varchar(45)
);

create table TrinhDo(
IdTrinhDo int primary key,
trinhDo varchar(45)
);

create table BoPhan(
IdBoPhan int primary key,
tenBoPhan varchar(45)
);

create table NhanVien(
IdNhanVien int primary key,
hoTen varchar(45),
IdViTri int,
IdTrinhDo int,
IdBoPhan int,
ngaySinh date,
soCMND varchar(45),
luongNV varchar(45),
SDT varchar(45),
email varchar(45),
diaChi varchar(45),
foreign key (IdViTri) references ViTri(IdViTri),
foreign key (IdTrinhDo) references TrinhDo(IdTrinhDo),
foreign key (IdBoPhan) references BoPhan(IdBoPhan)
);

create table LoaiKhach(
IdLoaiKhach int primary key,
tenLoaiKhach varchar(45)
);

create table KhachHang(
IdKhachHang int primary key,
IdLoaiKhach int,
hoTen varchar(45),
ngaySinh date,
soCMND varchar(45),
SDT varchar(45),
email varchar(45),
diaChi varchar(45),
foreign key (IdLoaiKhach) references LoaiKhach(IdLoaiKhach)
);

create table KieuThue(
IdKieuThue int primary key,
tenKieuThue varchar(45),
gia int
);

create table LoaiDichVu(
IdLoaiDichVu int primary key,
tenLoaiDichVu varchar(45)
);

create table DichVu(
IdDichVu int primary key,
tenDichVu varchar(45),
dienTich int,
soTang int,
soNguoiToiDa int,
chiPhiThue int,
IdKieuThue int,
IdLoaiDichVu int,
trangThai varchar(45),
foreign key (IdKieuThue) references KieuThue(IdKieuThue),
foreign key (IdLoaiDichVu) references LoaiDichVu(IdLoaiDichVu)
);

alter table DichVu
	modify chiPhiThue int; 
create table HopDong(
IdHopDong int primary key,
IdNhanVien int,
IdKhachHang int,
IdDichVu int,
ngayLamHopDong date,
ngayKetThucHopDong date,
tienDatCoc int,
tongTien int,
foreign key (IdNhanVien) references NhanVien(IdNhanVien),
foreign key (IdKhachHang) references KhachHang(IdKhachHang),
foreign key (IdDichVu) references DichVu(IdDichVu)
);

create table DichVuDiKem(
IdDichVuDiKem int primary key,
tenDichVuDiKem varchar(45),
gia int,
donVi int,
trangThaiKhaDung varchar(45)
);

create table HopDongChiTiet(
IdHopDongChiTiet int primary key,
IdHopDong int,
IdDichVuDiKem int,
soLuong int,
foreign key (IdHopDong) references HopDong(IdHopDong),
foreign key (IdDichVuDiKem) references DichVuDiKem(IdDichVuDiKem)
);