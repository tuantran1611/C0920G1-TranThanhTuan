package exam_2.models;

public class SoNganHan extends SoTietKiem {
    private String kyHan;

    public SoNganHan() {
    }

    public SoNganHan(String maSoSo, int maKhachHang, String ngayMoSo, String thoiGianGui, String soTienGui, String laiSuat, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
        this.kyHan = kyHan;
    }

    public SoNganHan(String maSoSo, int maKhachHang, String ngayMoSo, String thoiGianGui, String soTienGui, String laiSuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SoNganHan{" +
                "kyHan='" + kyHan + '\'' +
                '}';
    }
}
