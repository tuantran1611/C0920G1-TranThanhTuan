package exam_2.models;

public class SoDaiHan extends SoTietKiem {
    private String kyHan;
    private String uuDai;

    public SoDaiHan() {
    }

    public SoDaiHan(String maSoSo, int maKhachHang, String ngayMoSo, String thoiGianGui, String soTienGui,
                    String laiSuat, String kyHan, String uuDai) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTienGui, laiSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SoDaiHan{" +
                "kyHan='" + kyHan + '\'' +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }
}
