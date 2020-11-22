package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteCustomer;
import case_study_module_2.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteCustomer {
    static Scanner scanner = new Scanner(System.in);
    public static void deleteCustomer(){
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        if (customerList.isEmpty()) {
            ShowInfoCustomer.showInfoCustomer();
        } else {
            ShowInfoCustomer.showInfoCustomer();
            List<Customer> customers = new ArrayList<>(customerList);
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (Customer customer : customers) {
                if (idEdit.equals(customer.getIdCus())) {
                    customers.remove(customer);
                    break;
                }
            }
            if (customerList.size() == 1){
                ReadWriteCustomer.creatFileCsv();
            } else {
                ReadWriteCustomer.creatFileCsv();
                for (Customer customer : customers) {
                    ReadWriteCustomer.writeCustomerInfo(customer);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }
}
