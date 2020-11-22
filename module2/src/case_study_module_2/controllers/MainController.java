package case_study_module_2.controllers;

import case_study_module_2.commons.*;
import case_study_module_2.models.*;
import case_study_module_2.services.*;

import java.util.*;

public class MainController {

    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("1. Add new services\n" +
                "2. Show services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show All Booking\n" +
                "7. Show Information of Employee\n" +
                "8. Search Information of Employee\n" +
                "9. Buy ticket film\n" +
                "10. Show ticket film\n" +
                "11. Delete Services\n" +
                "12. Edit Services\n" +
                "13. Delete Customer\n" +
                "14. Edit Customer\n" +
                "15. Exit"
        );
        switch (scanner.nextInt()) {
            case 1:
                AddNewServices.addNewServices();
                break;
            case 2:
                ShowService.showServices();
                break;
            case 3:
                AddNewCustomer.addNewCustomer();
                displayMainMenu();
                break;
            case 4:
                ShowInfoCustomer.showInfoCustomer();
                displayMainMenu();
                break;
            case 5:
                AddNewBooking.addNewBooking();
                break;
            case 6:
                ShowAllBooking.showAllBooking();
                displayMainMenu();
                break;
            case 7:
                ShowInfoEmployee.showInfoEmployee();
                displayMainMenu();
                break;
            case 8:
                Cabinet.searchProfileEmployee();
                displayMainMenu();
                break;
            case 9:
                BuyTicket.buyTicket();
                displayMainMenu();
                break;
            case 10:
                BuyTicket.showTicket();
                displayMainMenu();
                break;
            case 11:
                DeleteServices.deleteServices();
                break;
            case 12:
                EditServices.editServices();
                break;
            case 13:
                DeleteCustomer.deleteCustomer();
                displayMainMenu();
                break;
            case 14:
                EditCustomer.editCustomer();
                displayMainMenu();
                break;
            case 15:
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                displayMainMenu();
                break;
        }
    }
}