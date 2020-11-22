package case_study_module_2.services;

import case_study_module_2.commons.CompareBirthDayCustomer;
import case_study_module_2.commons.ReadWriteCustomer;
import case_study_module_2.models.Customer;

import java.util.List;

public class ShowInfoCustomer {
    public static void showInfoCustomer() {
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        customerList.sort(new CompareBirthDayCustomer());
        if (customerList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Customer customer : customerList) {
                customer.showInfo();
            }
        }
    }
}
