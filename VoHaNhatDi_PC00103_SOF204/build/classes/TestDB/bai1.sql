/*Xem*/
Select * from NhanVien
Select * from ChuyenDe
Select * from NguoiHoc
Select * from KhoaHoc
Select * from HocVien
/*Thêm mới*/
INSERT INTO NhanVien VALUES (?,?,?,?)
INSERT INTO ChuyenDe VALUES (?,?,?,?,?,?)
Insert into NguoiHoc values (?,?,?,?,?,?,?,?,?)
Insert into KhoaHoc values (?,?,?,?,?,?,?)
Insert into HocVien values (?,?,?)
/*Sữa*/
Update NhanVien set MatKhau=?,HoTen=?,VaiTro=? where MaNV=?
Update ChuyenDe set TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? where MaCD=?
Update NguoiHoc set HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?, MaNV=?, NgayDK=? where MaNH=?
Update KhoaHoc set MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=?, NgayTao=? where MaKH=?
Update HocVien set MaKH=?, MaNH=?, Diem=? where MaHV=?
/*Xoá*/
Delete from NhanVien where MaNV=?
Delete from ChuyenDe where MaCD=?
Delete from NguoiHoc where MaNH=?
Delete from KhoaHoc where MaKH=?
Delete from HocVien where MaHV=?
/*--------------------------------*/
CREATE PROC sp_ThongKeNguoiHoc 
AS BEGIN  
		SELECT   
			YEAR(NgayDK) Nam,   
			COUNT(*) SoLuong,   
			MIN(NgayDK) DauTien,   
			MAX(NgayDK) CuoiCung  
		FROM NguoiHoc  
		GROUP BY YEAR(NgayDK) 
END 

/*--------------------------------*/
CREATE PROC sp_ThongKeDoanhThu(@Year INT) 
AS BEGIN  
	SELECT 
		TenCD ChuyenDe,
		COUNT(DISTINCT kh.MaKH) SoKH,
		COUNT(hv.MaHV) SoHV,
		SUM(kh.HocPhi) DoanhThu,
		MIN(kh.HocPhi) ThapNhat,
		MAX(kh.HocPhi) CaoNhat,   
		AVG(kh.HocPhi) TrungBinh  
	FROM KhoaHoc kh   
		JOIN HocVien hv ON kh.MaKH=hv.MaKH   
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD  
	WHERE YEAR(NgayKG) = @Year  
	GROUP BY TenCD 
END
/*--------------------------------*/
CREATE PROC sp_ThongKeDiem AS BEGIN  
	SELECT   
		TenCD ChuyenDe,   
		COUNT(MaHV) SoHV,  
		MIN(Diem) ThapNhat,   
		MAX(Diem) CaoNhat,   
		AVG(Diem) TrungBinh  
	FROM KhoaHoc kh   
		JOIN HocVien hv ON kh.MaKH=hv.MaKH   
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD  
	GROUP BY TenCD 
END
/*--------------------------------*/
CREATE PROC sp_BangDiem(@MaKH INT)
AS BEGIN  
	SELECT   
		nh.MaNH,   
		nh.HoTen,   
		hv.Diem  
	FROM HocVien hv   
		JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH  
	WHERE hv.MaKH = @MaKH  
	ORDER BY hv.Diem DESC 
END