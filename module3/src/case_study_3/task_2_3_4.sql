use casestudy3;
-- Task 2
select * from NhanVien where (hoTen like 'H%'  or hoTen like'T%' or hoTen like 'K%') and length(hoTen) < 16 ;
-- Task 3
select * from KhachHang where (year(curdate()) - year(ngaySinh) >= 18 and year(curdate()) - year(ngaySinh) <= 50 and (diaChi = 'Da Nang' or diaChi = 'Quang Tri'));
-- Task 4
select KhachHang.hoTen, LoaiKhach.tenLoaiKhach, HopDong.cnt from KhachHang 
join (select HopDong.IdKhachHang, count(HopDong.IdKhachHang) as cnt  from HopDong group by IdKhachHang) HopDong 
on KhachHang.IdKhachHang = HopDong.IdKhachHang
join LoaiKhach on KhachHang.IdLoaiKhach = LoaiKhach.IdLoaiKhach
where KhachHang.IdLoaiKhach = 1 order by HopDong.cnt ASC;
-- Task 5
select KhachHang.hoTen, HopDong.IdHopDong, DichVu.tenDichVu, HopDong.ngayLamHopDong, HopDong.ngayKetThucHopDong, DichVu.chiPhiThue,  DichVuDiKem.tenDichVuDiKem, DichVuDiKem.gia, HopDongChiTiet.soLuong,
(DichVu.chiPhiThue + DichVuDiKem.gia * HopDongChiTiet.soLuong) as TongTien 
from  KhachHang 
left join HopDong on  KhachHang.IdKhachHang= HopDong.IdKhachHang
left join DichVu on HopDong.IdDichVu = DichVu.IdDichVu
left join HopDongChiTiet on KhachHang.IdKhachHang = HopDongChiTiet.IdHopDongChiTiet
left join DichVuDiKem on HopDongChiTiet.IdDichVuDiKem = DichVuDiKem.IdDichVuDiKem
order by KhachHang.hoTen ASC;
-- Task 6
select DichVu.IdDichVu, DichVu.tenDichVu, KieuThue.tenKieuThue, DichVu.dienTich, DichVu.chiPhiThue, 
LoaiDichVu.tenLoaiDichVu from DichVu 
left join HopDong on DichVu.IdDichVu = HopDong.IdDichVu
left join KieuThue on DichVu.IdKieuThue = KieuThue.IdKieuThue
left join LoaiDichVu on DichVu.IdLoaiDichVu = LoaiDichVu.IdLoaiDichVu
where ((year(HopDong.ngayLamHopDong) <2020 and month(HopDong.ngayLamHopDong) < 4) or year(HopDong.ngayLamHopDong)< 2019
or HopDong.IdDichVu is null)
order by DichVu.IdDichVu;
-- Task 7
select DichVu.IdDichVu, HopDong.ngayLamHopDong, DichVu.tenDichVu, KieuThue.tenKieuThue, DichVu.dienTich,DIchVu.soNguoiToiDa, DichVu.chiPhiThue, 
LoaiDichVu.tenLoaiDichVu from DichVu 
join HopDong on DichVu.IdDichVu = HopDong.IdDichVu
join KieuThue on DichVu.IdKieuThue = KieuThue.IdKieuThue
join LoaiDichVu on DichVu.IdLoaiDichVu = LoaiDichVu.IdLoaiDichVu
where year(HopDong.ngayLamHopDong) = 2018 and HopDong.IdDichVu 
not in (select HopDong.IdDichVu from HopDong 
		where year(HopDong.ngayLamHopDong) = 2019);
-- Task 8
select distinct hoTen from KhachHang;
select hoTen from KhachHang group by hoTen;
select hoTen from KhachHang 
union
select hoTen from KhachHang;
-- Task 9
select year(HopDong.ngayLamHopDong) as Nam ,month(HopDong.ngayLamHopDong) as Thang, count(HopDong.IdKhachHang) as SoLuongKhachDatPhong from HopDong
where year(HopDong.ngayLamHopDong) = 2019
group by Thang;
-- Task 10
select HopDong.IdHopDong, HopDong.ngayLamHopDong, HopDong.ngayKetThucHopDong, HopDong.TienDatCoc, count(HopDongChiTiet.IdHopDongChiTiet) as SoLuongDichVuDiKem 
from HopDong
join HopDongChiTiet on HopDongChiTiet.IdHopDong = HopDong.IdHopDong
group by HopDongChiTiet.IdHopDong;
-- Task 11
select distinct KhachHang.IdKhachHang, KhachHang.hoTen, KhachHang.diaChi, DichVuDiKem.IdDichVuDiKem, DichVuDiKem.tenDichVuDiKem, DichVuDiKem.gia, DichVuDiKem.donVi, DichVuDiKem.trangThaiKhaDung from DichVuDiKem 
left join HopDongChiTiet on DichVuDiKem.IdDichVuDiKem = HopDongChiTiet.IdDichVuDiKem
left join HopDong on HopDongChiTiet.IdHopDong = HopDong.IdHopDong
left join KhachHang on HopDong.IdKhachHang = KhachHang.IdKhachHang
left join LoaiKhach on Khachhang.IdLoaiKhach = LoaiKhach.IdLoaiKhach
where LoaiKhach.tenLoaiKhach = 'Diamond' and (KhachHang.diaChi = 'Quang Ngai' or KhachHang.diaChi = 'Vinh');

use casestudy3;
-- Task 12
select HopDong.IdHopDong, NhanVien.hoTen as HoTenNhanVien,  KhachHang.hoTen as HoTenKhachHang, HopDong.ngayLamHopDong, KhachHang.SDT, DichVu.IdDichVu, DichVu.tenDichVu, count(HopDongChiTiet.IdHopDongChiTiet) as SoLuongDichVuDiKem , HopDong.tienDatCoc
from KhachHang
left join HopDong on  KhachHang.IdKhachHang = HopDong.IdKhachHang
left join NhanVien on HopDong.IdNhanVien = NhanVien.IdNhanVien
left join DichVu on HopDong.IdDichVu = DichVu.IdDichVu
left join HopDongChiTiet on HopDongChiTiet.IdHopDong = HopDong.IdHopDong
where (year(HopDong.ngayLamHopDong) = 2019 and month(HopDong.ngayLamHopDong) between 10 and 12) and HopDong.IdDichVu
not in (select HopDong.IdDichVu from HopDong where year(HopDong.ngayLamHopDong) = 2019 and month(HopDong.ngayLamHopDong) between 1 and 9)
group by HopDong.IdHopDong;
-- Task 13
select HopDongChiTiet.IdDichVuDiKem, DichVuDiKem.tenDichVuDiKem, DichVuDiKem.gia, DichVuDiKem.trangThaiKhaDung, count(HopDongChiTiet.IdDichVuDiKem) as TongLanDat 
from HopDongChiTiet 
join DichVuDiKem on HopDongChiTiet.IdDichVuDiKem = DichVuDiKem.IdDichVuDiKem
group by HopDongChiTiet.IdDichVuDiKem
having TongLanDat = (select max(mycount) from
(select HopDongChiTiet.IdDichVuDiKem, count(HopDongChiTiet.IdDichVuDiKem) as mycount from HopDongChiTiet group by HopDongChiTiet.IdDichVuDiKem) as MyAlias);
-- Mọi bảng dẫn xuất phải có bí danh riêng. Ở đây Bảng dẫn xuất đc đặt tên là MyAlias.
-- Task 14
select HopDong.IdHopDong, LoaiDichVu.tenLoaiDichVu, HopDongChiTiet.IdDichVuDiKem, DichVuDiKem.tenDichVuDiKem, DichVuDiKem.gia, DichVuDiKem.trangThaiKhaDung, count(HopDongChiTiet.IdDichVuDiKem) as SoLanSuDung 
from HopDongChiTiet 
join HopDong on HopDongChiTiet.IdHopDong = HopDong.IdHopDong
join DichVu on HopDong.IdDichVu = DichVu.IdDichVu
join LoaiDichVu on DichVu.IdLoaiDichVu = LoaiDichVu.IdLoaiDichVu
join DichVuDiKem on HopDongChiTiet.IdDichVuDiKem = DichVuDiKem.IdDichVuDiKem
group by HopDongChiTiet.IdDichVuDiKem
having SoLanSuDung = 1;
-- Task 15
select NhanVien.IdNhanVien, NhanVien.hoTen, TrinhDo.trinhDo, BoPhan.tenBoPhan, NhanVien.SDT, NhanVien.DiaChi, count(HopDong.IdNhanVien) as TongSoLan from HopDong
join NhanVien on HopDong.IdNhanVien = NhanVien.IdNhanVien
join TrinhDo on NhanVien.IdTrinhDO = TrinhDo.IdTrinhDo
join BoPhan on NhanVien.IdBoPhan = BoPhan.IdBoPhan
where year(HopDong.ngayLamHopDong) between 2018 and 2019
group by HopDong.IdNhanVien
having  TongSoLan < 4; 
-- Task 16
delete from NhanVien
where IdNhanVien = 
(select HopDong.IdNhanVien from HopDong
join NhanVien on HopDong.IdNhanVien = NhanVien.IdNhanVien
where year(HopDong.ngayLamHopDong) = 2019
group by HopDong.IdNhanVien
having (select mycount from( select HopDong.IdNhanVien, count(HopDong.IdNhanVien) as mycount from HopDOng group by HopDong.IdNhanVien) as MyAlias) < 1 );








