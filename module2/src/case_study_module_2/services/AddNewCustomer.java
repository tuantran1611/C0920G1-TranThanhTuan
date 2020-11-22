package case_study_module_2.services;

import case_study_module_2.commons.*;
import case_study_module_2.models.Customer;

import java.util.Scanner;

public class AddNewCustomer {
    public static void addNewCustomer() {
        Customer customer = new Customer();
        System.out.println("Bạn đã nhập thành công");
        ReadWriteCustomer.writeCustomerInfo(addCustomerInfo(customer));
    }

    public static Customer addCustomerInfo(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        boolean check = false;
        do {
            try {
                System.out.println("Nhập số ID: ");
                String idCus = scanner.nextLine();
                if (ValidateData.validateCmndCustomer(idCus)) {
                    customer.setIdCus(idCus);
                    check = true;
                } else {
                    throw new IdCardException("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String nameCustomer = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCustomer.trim())) {
                    customer.setNameCustomer(nameCustomer.trim());
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
                    customer.setBirthday(birthDay);
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
                    customer.setGender(genderNew.toString());
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
                System.out.println("Nhập số CMND: ");
                String cmnd = scanner.nextLine();
                if (ValidateData.validateCmndCustomer(cmnd)) {
                    customer.setCmnd(cmnd);
                    check = true;
                } else {
                    throw new IdCardException("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String phoneNumber = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(phoneNumber)) {
                    customer.setPhoneNumber(phoneNumber);
                    check = true;
                } else {
                    throw new PhoneNumberException("Số điện thoại chỉ có 10 số và bắt đầu bằng số 0");
                }
            } catch (PhoneNumberException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập email: ");
                String email = scanner.nextLine();
                if (ValidateData.validateEmailCustomer(email)) {
                    customer.setEmail(email);
                    check = true;
                } else {
                    throw new EmailException("Email phải đúng định dạng abc@abc.abc");
                }
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.println("Nhập loại khách: ");
        customer.setCustomerType(scanner.nextLine());
        System.out.println("Nhập địa chỉ: ");
        customer.setAddress(scanner.nextLine());
        return customer;
    }
}