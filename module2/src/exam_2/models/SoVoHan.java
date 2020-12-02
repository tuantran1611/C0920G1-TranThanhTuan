package exam_2.models;

public class SoVoHan extends SoTietKiem {
    public SoVoHan() {
    }

    public SoVoHan(String maSoSo, int maKhachHang, String ngayMoSo, String thoiGianGui, String soTienGui, String laiSuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
