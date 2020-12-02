package on_tap_2.function;

import on_tap_2.controllers.MainController;
import on_tap_2.models.PhoneBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SaveInFile {
    static Scanner scanner = new Scanner(System.in);
    public static void saveInFile(List<PhoneBook> phoneBookList){
        System.out.println("Bạn có muốn lưu file vào Csv không? \n" +
                "1. Yes\n" + "2. No");
        if ("Y".equals(scanner.nextLine())) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/on_tap_2/data/contacts.csv"), true));
                for (PhoneBook phoneBook : phoneBookList){
                    bw.write(phoneBook.getPhoneNumber()+","+phoneBook.getGroupPhoneBook()+","+
                            phoneBook.getFullName()+","+phoneBook.getGender()+","+phoneBook.getBirthDay()+","+
                            phoneBook.getEmail());
                    bw.newLine();
                }
                bw.close();
                System.out.println("Nhập thành công");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Vui lòng nhập lại");
            MainController.displayMenu();
        }
    }
}
