package exam_2.controllers;

import exam_2.function.*;

import java.util.Scanner;

public class MainControllers {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMenu(){
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆN");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. Thêm mới sổ tiết kiệm");
        System.out.println("2. Xóa sổ tiết kiệm");
        System.out.println("3. Xem danh sách sổ tiết kiệm");
        System.out.println("4. Xem thông tin sổ tiết kiệm");
        System.out.println("5. Xem thông tin khách hàng");
        System.out.println("6. Thoát");
        System.out.println("Chọn chức năng : ");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                ThemSoTietKiem.themSoTietKiem();
                displayMenu();
                break;
            case "2":
                XoaSoTietKiem.xoaSoTietKiem();
                displayMenu();
                break;
            case "3":
                XemDanhSachSoTietKiem.xemDanhSachSo();
                displayMenu();
                break;
            case "4":
                TimKiemSoTietKiem.timKiemSoTietKiem();
                displayMenu();
                break;
            case "5":
                XemThongTinKhachHang.xemThongTinKhachHang();
                displayMenu();
                break;
            case "6":
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                displayMenu();
        }
    }
}
