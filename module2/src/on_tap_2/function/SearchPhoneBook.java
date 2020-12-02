package on_tap_2.function;

import case_study_module_2.commons.NameException;
import case_study_module_2.commons.PhoneNumberException;
import case_study_module_2.commons.ValidateData;
import on_tap_2.controllers.MainController;
import on_tap_2.models.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class SearchPhoneBook {
    static Scanner scanner = new Scanner(System.in);
    public static void searchPhoneBook(){
        List<PhoneBook> phoneBookList = AddNewPhoneBook.getPhoneBookList();

        boolean check = false;
        if (phoneBookList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            do {
                System.out.println("Nhập vào số điện thoại hoặc tên bạn muốn tìm");
                String delPhoneBook = scanner.nextLine();
                try {
                    if (ValidateData.validatePhoneCustomer(delPhoneBook) | ValidateData.validateNameCustomer(delPhoneBook)) {
                        for (PhoneBook phoneBook : phoneBookList) {
                            if (phoneBook.getPhoneNumber().contains(delPhoneBook) | phoneBook.getFullName().contains(delPhoneBook)) {
                                System.out.println(phoneBook.toString());
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Bạn đã tìm thành công");
                        } else {
                            System.out.println("Số điện thoại hoặc tên bạn nhập không có, vui lòng nhập lại");
                            searchPhoneBook();
                        }
                    } else {
                        throw new PhoneNumberException("Vui lòng nhập đúng định dạng");
                    }
                } catch (PhoneNumberException e) {
                    e.getMessage();
                }
            } while (!check);
        }
    }
}
