//package on_tap_1.controllers;
//
//import on_tap_1.function.AddProduct;
//import on_tap_1.function.DeleteProduct;
//import on_tap_1.function.SearchProduct;
//import on_tap_1.function.ShowListProduct;
//
//import java.util.Scanner;
//
//public class MainControllers {
//    static Scanner scanner = new Scanner(System.in);
//    public static void displayMenu(){
//        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
//        System.out.println("Chọn chức năng theo số để tiếp tục");
//        System.out.println("1. Thêm mới");
//        System.out.println("2. Xóa");
//        System.out.println("3. Xem danh sách sản phẩm");
//        System.out.println("4. Tìm kiếm");
//        System.out.println("5. Thoát");
//        System.out.println("Chọn chức năng : ");
//        String choice = scanner.nextLine();
//        switch (choice){
//            case "1":
//                AddProduct.addProduct();
//                displayMenu();
//                break;
//            case "2":
//                DeleteProduct.deleteProduct();
//                displayMenu();
//                break;
//            case "3":
//                ShowListProduct.showListProduct();
//                displayMenu();
//                break;
//            case "4":
//                SearchProduct.searchProduct();
//                displayMenu();
//                break;
//        }
//    }
//}
