package on_tap_2.controllers;

import on_tap_2.function.*;

import java.util.Scanner;

public class MainController {

    static Scanner scanner = new Scanner(System.in);
    public static void displayMenu(){
        System.out.println("-------Menu-------\n" +
                "1./ Xem danh sách\n" +
                "2./ Thêm mới danh bạ\n" +
                "3./ Cập nhập danh bạ\n" +
                "4./ Xóa\n" +
                "5./ Tìm kiếm\n" +
                "6./ Đọc từ file\n" +
                "7./ Ghi vào file\n");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                ShowPhoneBook.showPhoneBook();
                displayMenu();
                break;
            case "2":
                AddNewPhoneBook.addNewPhoneBook();
                displayMenu();
                break;
            case "3":
                UpdatePhoneBook.updatePhoneBook();
                displayMenu();
                break;
            case "4":
                DeletePhoneBook.deletePhoneBook();
                displayMenu();
                break;
            case "5":
                SearchPhoneBook.searchPhoneBook();
                displayMenu();
                break;
            case "6":
                ReadFromCsv.readFromCsv(AddNewPhoneBook.getPhoneBookList());
                displayMenu();
                break;
            case "7":
                SaveInFile.saveInFile(AddNewPhoneBook.getPhoneBookList());
                displayMenu();
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                displayMenu();
                break;
        }
    }
}
