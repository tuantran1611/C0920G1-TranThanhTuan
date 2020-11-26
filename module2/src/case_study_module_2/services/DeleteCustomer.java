package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteCustomer;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteCustomer {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList = ReadWriteCustomer.readCustomer();
    static List<Customer> customers = new ArrayList<>(customerList);
    public static void deleteCustomer(){
        if (customerList.isEmpty()) {
            ShowInfoCustomer.showInfoCustomer();
        } else {
            ShowInfoCustomer.showInfoCustomer();
            checkDeleteCustomer();
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

    public static void checkDeleteCustomer(){
        System.out.println("Nhập ID bạn muốn xóa");
        String idEdit = scanner.nextLine();
        for (Customer customer : customers) {
            if (idEdit.equals(customer.getIdCus())) {
                System.out.println("Bạn có muốn xóa hay không\n" +
                        "1./ Yes\n"  + "2./ No");
                if (scanner.nextInt() == 1){
                    customers.remove(customer);
                    break;
                } else if (scanner.nextInt() == 2){
                    MainController.displayMainMenu();
                    break;
                } else {
                    System.out.println("Nhập sai vui lòng nhập lại");
                    deleteCustomer();
                    break;
                }
            }
        }
    }
}
