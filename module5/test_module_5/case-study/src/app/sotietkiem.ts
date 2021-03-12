import {KhachHang} from './khachhang';

export class SoTietKiem {
  id: number;
  idKhach: KhachHang;
  tenKhach: KhachHang;
  ngayMo: string;
  ngayGui: string;
  kiHan: string;
  soTien: string;
  laiSuat: string;
  uuDai: string;
  // tslint:disable-next-line:max-line-length
  constructor(id: number, idKhach: KhachHang, tenKhach: KhachHang, ngayMo: string, ngayGui: string, kiHan: string, soTien: string, laiSuat: string, uuDai: string) {
    this.id = id;
    this.idKhach = idKhach;
    this.tenKhach = tenKhach;
    this.ngayMo = ngayMo;
    this.ngayGui = ngayGui;
    this.kiHan = kiHan;
    this.soTien = soTien;
    this.laiSuat = laiSuat;
    this.uuDai = uuDai;
  }
}
