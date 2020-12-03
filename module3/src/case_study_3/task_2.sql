use casestudy3;
select * from NhanVien where (hoTen like 'H%'  or hoTen like'T%' or hoTen like 'K%') and length(hoTen) < 16 ;

select * from KhachHang where (year(curdate()) - year(ngaySinh) >= 18 and year(curdate()) - year(ngaySinh) <= 50 and (diaChi = 'Da Nang' or diaChi = 'Quang Tri'));

select KhachHang.hoTen, LoaiKhach.tenLoaiKhach, HopDong.cnt from KhachHang 
join (select HopDong.IdKhachHang, count(HopDong.IdKhachHang) as cnt  from HopDong group by IdKhachHang) HopDong 
on KhachHang.IdKhachHang = HopDong.IdKhachHang
join LoaiKhach on KhachHang.IdLoaiKhach = LoaiKhach.IdLoaiKhach
where KhachHang.IdLoaiKhach = 1 order by HopDong.cnt ASC;

