package models;

public class BenhAn {
    private String idBenhAn;
    private BenhNhan idbenhNhan;
    private BenhNhan tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDoNhapVien;

    public BenhAn(String idBenhAn, BenhNhan idbenhNhan, BenhNhan tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.idBenhAn = idBenhAn;
        this.idbenhNhan = idbenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public String getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(String idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public BenhNhan getIdbenhNhan() {
        return idbenhNhan;
    }

    public void setIdbenhNhan(BenhNhan idbenhNhan) {
        this.idbenhNhan = idbenhNhan;
    }

    public BenhNhan getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(BenhNhan tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
