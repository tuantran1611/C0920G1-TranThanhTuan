package exam_2.function;


import case_study_module_2.commons.*;
import exam_2.commons.ReadWriteSo;
import exam_2.commons.RegexData;
import exam_2.controllers.MainControllers;
import exam_2.models.KhachHang;
import exam_2.models.SoDaiHan;
import exam_2.models.SoNganHan;
import exam_2.models.SoVoHan;

import java.util.Scanner;

public class ThemSoTietKiem {

    private static final String FILE_PATH_1 = "src/exam_2/data/longTerm.csv";
    private static final String FILE_PATH_2 = "src/exam_2/data/shortTerm.csv";
    private static final String FILE_PATH_3 = "src/exam_2/data/customers.csv";

    public static String getFilePath1() {
        return FILE_PATH_1;
    }

    public static String getFilePath2() {
        return FILE_PATH_2;
    }

    public static String getFilePath3() {
        return FILE_PATH_3;
    }

    static Scanner scanner = new Scanner(System.in);
    static int count1 = 0;
    static int count2= 0;
    public static void themSoTietKiem() {
        System.out.println("Chon số chức năng để tiếp tục");
        System.out.println("1. Sổ tiết kiệm dài hạn");
        System.out.println("2. Sổ tiết kiệm ngắn hạn");
        switch (scanner.nextLine()) {
            case "1":
                themThongTinSoDaiHan();
                MainControllers.displayMenu();
                break;
            case "2":
                System.out.println("1. Vô thời hạn\n" +"2. Có thời hạn");
                switch (scanner.nextLine()){
                    case "1":
                        themThongTinSoNganHan();
                        MainControllers.displayMenu();
                        break;
                    case "2":
                        themThongTinSoVoHan();
                        MainControllers.displayMenu();
                        break;
                }
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                MainControllers.displayMenu();
                break;
        }
    }

    public static void themThongTinSoDaiHan() {
        SoDaiHan soDaiHan = new SoDaiHan();
        KhachHang khachHang = new KhachHang();
        count1 += 1;
        boolean check = false;
        khachHang.setMaKhachHang(count1);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String nameCustomer = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCustomer.trim())) {
                    khachHang.setTenKhachHang(nameCustomer.trim());
                    check = true;
                } else {
                    throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                if (ValidateData.validateBirthDay(birthDay)) {
                    khachHang.setNgaySinh(birthDay);
                    check = true;
                } else {
                    throw new BirthDayException("Năm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
                }
            } catch (BirthDayException e) {
                System.err.println(e.getMessage());
            }

        } while (!check);

        check = false;
        do {
            try {
                System.out.println("Nhập giới tính: ");
                String gender = scanner.nextLine();
                if (ValidateData.validateGenderCustomer(gender)) {
                    String[] str = (gender.toLowerCase()).split("");
                    StringBuilder genderNew = new StringBuilder(str[0].toUpperCase());
                    for (int i = 1; i < str.length; i++) {
                        genderNew.append(str[i]);
                    }
                    khachHang.setGioiTinh(genderNew.toString());
                    check = true;
                } else {
                    throw new GenderException("Nhập sai giới tính , phải là Nam, Nu hoặc unknow");
                }
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String soDienThoai = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(soDienThoai)) {
                    khachHang.setSoDienThoai(soDienThoai);
                    check = true;
                } else {
                    throw new IdCardException("Số điện thoại có 10 số , bắt đầu bằng 0");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập địa chỉ: ");
                String diaChi = scanner.nextLine();
                if (ValidateData.validateNameCustomer(diaChi.trim())) {
                    khachHang.setDiaChi(diaChi.trim());
                    check = true;
                } else {
                    throw new NameException("Địa chỉ phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);

        check = false;
        do {
            System.out.println("Nhập mã số sổ");
            String maSoSo = scanner.nextLine();
            if (RegexData.regexMaSoSo(maSoSo)) {
                soDaiHan.setMaSoSo(maSoSo);
                check = true;
            } else {
                System.err.println("Vui lòng nhập đúng định dạng STK-XXXX, X là 4 số từ 0 - 9");
            }
        } while (!check);
        soDaiHan.setMaKhachHang(count1);
        check = false;
        do {
            System.out.println("Nhập ngày mở sổ");
            String ngayMoSo = scanner.nextLine();
            if (RegexData.regexNgayMoSo(ngayMoSo)) {
                soDaiHan.setNgayMoSo(ngayMoSo);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập thời gian bắt đầu gửi");
            String thoiGianGui = scanner.nextLine();
            if (RegexData.regexNgayMoSo(thoiGianGui)) {
                soDaiHan.setNgayMoSo(thoiGianGui);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số tiền gửi");
            String tienGui = scanner.nextLine();
            if (RegexData.regexSoTienGui(tienGui)) {
                soDaiHan.setSoTienGui(tienGui);
                check = true;
            } else {
                System.err.println("Số tiền gửi tối thiểu 1000000 đồng");
            }
        } while (!check);
        check = false;

        do {
            System.out.println("Nhập lãi suất");
            String laiSuat = scanner.nextLine();
            if (RegexData.regexPrice(laiSuat)) {
                soDaiHan.setLaiSuat(laiSuat);
                check = true;
            } else {
                System.err.println("Lãi suất là số dương");
            }
        } while (!check);

        check = false;
        do {
            System.out.println("Nhập kỳ hạn gửi");
            String kyHan = scanner.nextLine();
            if (RegexData.regexKyHanGui(kyHan)) {
                soDaiHan.setKyHan(kyHan);
                check = true;
            } else {
                System.err.println("Kỳ hạn 1 phải là 1 hoặc 3 hoặc 5 hoặc 10 năm");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập ưu đãi");
            String uuDai = scanner.nextLine();
            if (RegexData.regexPrice(uuDai)) {
                soDaiHan.setUuDai(uuDai);
                check = true;
            } else {
                System.err.println("Viết hoa chữ đầu");
            }
        } while (!check);

        String line = soDaiHan.getMaSoSo()+","+soDaiHan.getMaKhachHang()+","+soDaiHan.getNgayMoSo()+","+
                soDaiHan.getThoiGianGui()+","+soDaiHan.getSoTienGui()+","+soDaiHan.getLaiSuat()+","+
                soDaiHan.getKyHan()+","+soDaiHan.getUuDai();
        String line1 = khachHang.getMaKhachHang()+","+khachHang.getTenKhachHang()+","+khachHang.getNgaySinh()+","+khachHang.getGioiTinh()+","+
                khachHang.getSoDienThoai()+","+khachHang.getDiaChi();
        ReadWriteSo.writeFile(FILE_PATH_1,line);
        ReadWriteSo.writeFile(FILE_PATH_3,line1);
    }

    public static void themThongTinSoNganHan() {
        SoNganHan soNganHan = new SoNganHan();
        KhachHang khachHang = new KhachHang();
        count2 += 1;
        boolean check = false;
        khachHang.setMaKhachHang(count2);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String nameCustomer = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCustomer.trim())) {
                    khachHang.setTenKhachHang(nameCustomer.trim());
                    check = true;
                } else {
                    throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                if (ValidateData.validateBirthDay(birthDay)) {
                    khachHang.setNgaySinh(birthDay);
                    check = true;
                } else {
                    throw new BirthDayException("Năm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
                }
            } catch (BirthDayException e) {
                System.err.println(e.getMessage());
            }

        } while (!check);

        check = false;
        do {
            try {
                System.out.println("Nhập giới tính: ");
                String gender = scanner.nextLine();
                if (ValidateData.validateGenderCustomer(gender)) {
                    String[] str = (gender.toLowerCase()).split("");
                    StringBuilder genderNew = new StringBuilder(str[0].toUpperCase());
                    for (int i = 1; i < str.length; i++) {
                        genderNew.append(str[i]);
                    }
                    khachHang.setGioiTinh(genderNew.toString());
                    check = true;
                } else {
                    throw new GenderException("Nhập sai giới tính , phải là Nam, Nu hoặc unknow");
                }
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String soDienThoai = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(soDienThoai)) {
                    khachHang.setSoDienThoai(soDienThoai);
                    check = true;
                } else {
                    throw new IdCardException("Số điện thoại có 10 số , bắt đầu bằng 0");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập địa chỉ: ");
                String diaChi = scanner.nextLine();
                if (ValidateData.validateNameCustomer(diaChi.trim())) {
                    khachHang.setDiaChi(diaChi.trim());
                    check = true;
                } else {
                    throw new NameException("Địa chỉ phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
         check = false;
        do {
            System.out.println("Nhập mã số sổ");
            String maSoSo = scanner.nextLine();
            if (exam_2.commons.RegexData.regexMaSoSo(maSoSo)) {
                soNganHan.setMaSoSo(maSoSo);
                check = true;
            } else {
                System.err.println("Vui lòng nhập đúng định dạng STK-XXXX, X là 4 số từ 0 - 9");
            }
        } while (!check);
        soNganHan.setMaKhachHang(count2);
        check = false;
        do {
            System.out.println("Nhập ngày mở sổ");
            String ngayMoSo = scanner.nextLine();
            if (RegexData.regexNgayMoSo(ngayMoSo)) {
                soNganHan.setNgayMoSo(ngayMoSo);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập thời gian bắt đầu gửi");
            String thoiGianGui = scanner.nextLine();
            if (RegexData.regexNgayMoSo(thoiGianGui)) {
                soNganHan.setNgayMoSo(thoiGianGui);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số tiền gửi");
            String tienGui = scanner.nextLine();
            if (RegexData.regexSoTienGui(tienGui)) {
                soNganHan.setSoTienGui(tienGui);
                check = true;
            } else {
                System.err.println("Số tiền gửi tối thiểu 1000000 đồng");
            }
        } while (!check);
        check = false;

        do {
            System.out.println("Nhập lãi suất");
            String laiSuat = scanner.nextLine();
            if (RegexData.regexPrice(laiSuat)) {
                soNganHan.setLaiSuat(laiSuat);
                check = true;
            } else {
                System.err.println("Lãi suất là số dương");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập kỳ hạn gửi");
            String kyHan = scanner.nextLine();
            if (RegexData.regexKyHanGuiNganHan(kyHan)) {
                soNganHan.setKyHan(kyHan);
                check = true;
            } else {
                System.err.println("Kỳ hạn phải là 3 hoặc 6 tháng");
            }
        } while (!check);

        String line = soNganHan.getMaSoSo()+","+soNganHan.getMaKhachHang()+","+soNganHan.getNgayMoSo()+","+
                soNganHan.getThoiGianGui()+","+soNganHan.getSoTienGui()+","+soNganHan.getLaiSuat() +"," + soNganHan.getKyHan();
        ReadWriteSo.writeFile(FILE_PATH_2,line);
    }

    public static void themThongTinSoVoHan() {
        SoVoHan soVoHan = new SoVoHan();
        KhachHang khachHang = new KhachHang();
        count2 += 1;
        boolean check = false;
        khachHang.setMaKhachHang(count2);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String nameCustomer = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCustomer.trim())) {
                    khachHang.setTenKhachHang(nameCustomer.trim());
                    check = true;
                } else {
                    throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập ngày sinh: ");
                String birthDay = scanner.nextLine();
                if (ValidateData.validateBirthDay(birthDay)) {
                    khachHang.setNgaySinh(birthDay);
                    check = true;
                } else {
                    throw new BirthDayException("Năm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
                }
            } catch (BirthDayException e) {
                System.err.println(e.getMessage());
            }

        } while (!check);

        check = false;
        do {
            try {
                System.out.println("Nhập giới tính: ");
                String gender = scanner.nextLine();
                if (ValidateData.validateGenderCustomer(gender)) {
                    String[] str = (gender.toLowerCase()).split("");
                    StringBuilder genderNew = new StringBuilder(str[0].toUpperCase());
                    for (int i = 1; i < str.length; i++) {
                        genderNew.append(str[i]);
                    }
                    khachHang.setGioiTinh(genderNew.toString());
                    check = true;
                } else {
                    throw new GenderException("Nhập sai giới tính , phải là Nam, Nu hoặc unknow");
                }
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String soDienThoai = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(soDienThoai)) {
                    khachHang.setSoDienThoai(soDienThoai);
                    check = true;
                } else {
                    throw new IdCardException("Số điện thoại có 10 số , bắt đầu bằng 0");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập địa chỉ: ");
                String diaChi = scanner.nextLine();
                if (ValidateData.validateNameCustomer(diaChi.trim())) {
                    khachHang.setDiaChi(diaChi.trim());
                    check = true;
                } else {
                    throw new NameException("Địa chỉ phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);

        do {
            System.out.println("Nhập mã số sổ");
            String maSoSo = scanner.nextLine();
            if (RegexData.regexMaSoSo(maSoSo)) {
                soVoHan.setMaSoSo(maSoSo);
                check = true;
            } else {
                System.err.println("Vui lòng nhập đúng định dạng STK-XXXX, X là 4 số từ 0 - 9");
            }
        } while (!check);
        soVoHan.setMaKhachHang(count2);
        check = false;
        do {
            System.out.println("Nhập ngày mở sổ");
            String ngayMoSo = scanner.nextLine();
            if (RegexData.regexNgayMoSo(ngayMoSo)) {
                soVoHan.setNgayMoSo(ngayMoSo);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập thời gian bắt đầu gửi");
            String thoiGianGui = scanner.nextLine();
            if (RegexData.regexNgayMoSo(thoiGianGui)) {
                soVoHan.setNgayMoSo(thoiGianGui);
                check = true;
            } else {
                System.err.println("Ngày phải đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số tiền gửi");
            String tienGui = scanner.nextLine();
            if (RegexData.regexSoTienGui(tienGui)) {
                soVoHan.setSoTienGui(tienGui);
                check = true;
            } else {
                System.err.println("Số tiền gửi tối thiểu 1000000 đồng");
            }
        } while (!check);
        check = false;

        do {
            System.out.println("Nhập lãi suất");
            String laiSuat = scanner.nextLine();
            if (RegexData.regexPrice(laiSuat)) {
                soVoHan.setLaiSuat(laiSuat);
                check = true;
            } else {
                System.err.println("Lãi suất là số dương");
            }
        } while (!check);

        String line = soVoHan.getMaSoSo()+","+soVoHan.getMaKhachHang()+","+soVoHan.getNgayMoSo()+","+
                soVoHan.getThoiGianGui()+","+soVoHan.getSoTienGui()+","+soVoHan.getLaiSuat();
        String line1 = khachHang.getMaKhachHang()+","+khachHang.getTenKhachHang()+","+khachHang.getNgaySinh()+","+khachHang.getGioiTinh()+","+
                khachHang.getSoDienThoai()+","+khachHang.getDiaChi();
        ReadWriteSo.writeFile(FILE_PATH_2,line);
        ReadWriteSo.writeFile(FILE_PATH_3,line1);
    }
}