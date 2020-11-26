package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteCustomer;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.Customer;

import java.util.List;
import java.util.Scanner;

public class EditCustomer {
    static Scanner scanner = new Scanner(System.in);

    public static void editCustomer() {
        boolean check = false;
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        if (customerList.isEmpty()) {
            ShowInfoCustomer.showInfoCustomer();
        } else {
            ShowInfoCustomer.showInfoCustomer();
            System.out.println("Nhập ID bạn muốn sửa");
            String idEdit = scanner.nextLine();
            for (Customer customer : customerList) {
                if (idEdit.equals(customer.getIdCus())) {
                    checkEdit(customer);
                    check = true;
                    break;
                }
                check = false;
            }
            if (check){
                ReadWriteCustomer.creatFileCsv();
                for (Customer customer : customerList) {
                    ReadWriteCustomer.writeCustomerInfo(customer);
                }
                System.out.println("Bạn đã sửa thành công");
            } else {
                System.out.println("ID bạn nhập không đúng, vui lòng nhập lại");
                editCustomer();
            }
        }
    }

    public static void checkEdit(Customer customer){
        System.out.println("Bạn có muốn sửa không?\n" + "1./Yes\n" + "2./No");
        switch (scanner.nextInt()) {
            case 1:
                AddNewCustomer.addCustomerInfo(customer);
                break;
            case 2:
                MainController.displayMainMenu();
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                editCustomer();
                break;
        }
    }
}
