package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteBooking;
import case_study_module_2.models.Customer;

public class ShowAllBooking {
    public static void showAllBooking(){
        for (Customer customer : ReadWriteBooking.readBooking()) {
            System.out.print(customer.toString());
            customer.getUseService().showInfor();
        }
    }
}
