package on_tap_2.function;

import on_tap_2.controllers.MainController;
import on_tap_2.models.PhoneBook;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadFromCsv {
    static Scanner scanner = new Scanner(System.in);
    public static void readFromCsv(List<PhoneBook> phoneBookList){
        System.out.println("Bạn có muốn cập nhập file danh bạ từ file Csv không? \n" +
                "1. Yes\n" + "2. No");
        if ("Y".equals(scanner.nextLine())){
            phoneBookList.clear();
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("src/on_tap_2/data/contacts.csv")));
                String line;
                String[] str;
                while ((line = br.readLine()) != null){
                    str = line.split(",");
                    phoneBookList.add(new PhoneBook(str[0],str[1],str[2],str[3],str[4],str[5]));
                }
                br.close();
                System.out.println("Cập nhập thành công");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Vui lòng nhập lại");
            MainController.displayMenu();
        }
    }
}
