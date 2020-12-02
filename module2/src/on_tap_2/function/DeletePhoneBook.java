package on_tap_2.function;

import case_study_module_2.commons.PhoneNumberException;
import case_study_module_2.commons.ValidateData;
import on_tap_2.controllers.MainController;
import on_tap_2.models.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class DeletePhoneBook {
    static Scanner scanner = new Scanner(System.in);

    public static void deletePhoneBook() {
        List<PhoneBook> phoneBookList = AddNewPhoneBook.getPhoneBookList();
        boolean check = false;
        if (phoneBookList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            do {
                System.out.println("Nhập vào số điện thoại bạn muốn xóa");
                String phoneDel = scanner.nextLine();
                try {
                    if (ValidateData.validatePhoneCustomer(phoneDel)) {
                        for (PhoneBook phoneBook : phoneBookList) {
                            if (phoneDel.equals(phoneBook.getPhoneNumber())) {
                                System.out.println("Bạn có muốn xóa hay không (Bấm Y hoặc N) ?!!\n" + "1. Yes\n" + "2. No");
                                if ("Y".equals(scanner.nextLine())) {
                                    phoneBookList.remove(phoneBook);
                                    check = true;
                                } else {
                                    MainController.displayMenu();
                                }
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Bạn đã xóa thành công");
                        } else {
                            System.out.println("Số điện thoại bạn nhập không có, vui lòng nhập lại");
                            deletePhoneBook();
                        }
                    } else {
                        throw new PhoneNumberException("Vui lòng nhập đúng định dạng");
                    }
                } catch (PhoneNumberException e) {
                    e.printStackTrace();
                }
            } while (!check);
        }
    }
}
