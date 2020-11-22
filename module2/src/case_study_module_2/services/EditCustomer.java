package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteCustomer;
import case_study_module_2.models.Customer;

import java.util.List;
import java.util.Scanner;

public class EditCustomer {
    static Scanner scanner = new Scanner(System.in);

    public static void editCustomer() {
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        if (customerList.isEmpty()) {
            ShowInfoCustomer.showInfoCustomer();
        } else {
            ShowInfoCustomer.showInfoCustomer();
            System.out.println("Nhập ID bạn muốn sửa");
            String idEdit = scanner.nextLine();
            for (Customer customer : customerList) {
                if (idEdit.equals(customer.getIdCus())) {
                    AddNewCustomer.addCustomerInfo(customer);
                    break;
                }
            }
            ReadWriteCustomer.creatFileCsv();
            for (Customer customer : customerList) {
                ReadWriteCustomer.writeCustomerInfo(customer);
            }
            System.out.println("Bạn đã sửa thành công");
        }
    }
}
