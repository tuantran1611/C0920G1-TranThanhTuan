package on_tap_2.function;

import case_study_module_2.commons.PhoneNumberException;
import case_study_module_2.commons.ValidateData;
import on_tap_2.controllers.MainController;
import on_tap_2.models.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class UpdatePhoneBook {
    static Scanner scanner = new Scanner(System.in);
    public static void updatePhoneBook() {
        List<PhoneBook> phoneBookList = AddNewPhoneBook.getPhoneBookList();
        boolean check = false;
        do {
            System.out.println("Nhập số điện thoại bạn muốn update");
            String phone = scanner.nextLine();
            try {
                if (ValidateData.validatePhoneCustomer(phone)){
                    for (PhoneBook phoneBook : phoneBookList){
                        if (phone.equals(phoneBook.getPhoneNumber())){
                            System.out.println("Bạn có muốn sửa hay không (Bấm Y hoặc N) ?!!\n" + "1. Yes\n" + "2. No");
                            if ("Y".equals(scanner.nextLine())) {
                                AddNewPhoneBook.addPhoneBookInfo(phoneBook);
                                check = true;
                            } else {
                                MainController.displayMenu();
                            }
                            break;
                        }
                    }
                    if (check){
                        System.out.println("Bạn đã sửa thành công");
                    } else {
                        System.out.println("Số điện thoại bạn nhập không có, vui lòng nhập lại");
                    }
                } else {
                    throw new PhoneNumberException("Vui lòng nhập đúng định dạnh số điện thoại gồm 10 số");
                }
            } catch (PhoneNumberException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
    }
}
