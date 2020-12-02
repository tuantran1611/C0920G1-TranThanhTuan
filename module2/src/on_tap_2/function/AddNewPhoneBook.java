package on_tap_2.function;

import case_study_module_2.commons.*;
import on_tap_2.commons.PhoneNumberException;
import on_tap_2.models.PhoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewPhoneBook {

    static List<PhoneBook> phoneBookList = new ArrayList<>();

    public static List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public static void addNewPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBookList.add(addPhoneBookInfo(phoneBook));
        System.out.println("Bạn đã nhập thành công");
    }

    public static PhoneBook addPhoneBookInfo(PhoneBook phoneBook) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String phoneNumber = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(phoneNumber)) {
                    phoneBook.setPhoneNumber(phoneNumber);
                    check = true;
                } else {
                    throw new PhoneNumberException("Số điện thoại phải đúng định dạng");
                }
            } catch (PhoneNumberException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập nhóm: ");
                String group = scanner.nextLine();
                if (ValidateData.validateNameService(group)) {
                    phoneBook.setGroupPhoneBook(group);
                    check = true;
                } else {
                    throw new PhoneNumberException("Số điện thoại phải đúng định dạng");
                }
            } catch (PhoneNumberException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String fullName = scanner.nextLine();
                if (ValidateData.validateNameCustomer(fullName)) {
                    phoneBook.setFullName(fullName);
                    check = true;
                } else {
                    throw new NameException("Chữ cái đầu viết hoa");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập giới tính: ");
                String gender = scanner.nextLine();
                if (ValidateData.validateGenderCustomer(gender)) {
                    phoneBook.setGender(gender);
                    check = true;
                } else {
                    throw new GenderException("Nhập sai giới tính , phải là male, female hoặc unknow");
                }
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập ngày sinh   : ");
                String birthDay = scanner.nextLine();
                if (ValidateData.validateBirthDay(birthDay)) {
                    phoneBook.setBirthDay(birthDay);
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
                System.out.println("Nhập Email: ");
                String email = scanner.nextLine();
                if (ValidateData.validateEmailCustomer(email)) {
                    phoneBook.setEmail(email);
                    check = true;
                } else {
                    throw new EmailException("Email phải đúng định dạng abc@abc.abc");
                }
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        return phoneBook;
    }
}
