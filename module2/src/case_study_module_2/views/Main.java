package case_study_module_2.views;

import case_study_module_2.commons.ReadWriteBooking;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.Customer;

public class Main {
    public static void main(String[] args) {
        new MainController().displayMainMenu();
//        for (Customer customer : new ReadWriteBooking().readBookingVilla()) {
//            System.out.println(customer.toString() + customer.getUseService().toString());
//        }
    }
}