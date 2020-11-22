package case_study_module_2.services;

import case_study_module_2.commons.*;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.Customer;
import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.List;
import java.util.Scanner;

public class AddNewBooking {
    static Scanner scanner = new Scanner(System.in);
    public static void addNewBooking() {
        System.out.println("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Back to menu\n");
        switch (scanner.nextInt()) {
            case 1:
                bookingVilla();
                addNewBooking();
                break;
            case 2:
                bookingHouse();
                addNewBooking();
                break;
            case 3:
                bookingRoom();
                addNewBooking();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                addNewBooking();
                break;
        }
    }

    public static void bookingVilla() {
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        ShowInfoCustomer.showInfoCustomer();
        ShowService.showAllVilla();
        System.out.println("Nhập ID Customer: ");
        String idCus = scanner.nextLine();
        System.out.println("Chọn ID phòng: ");
        String choice = scanner.nextLine();
        boolean checkIdVilla = false;
        Customer customerNew;
        for (Villa villa : villaList) {
            if (villa.getId().equals(choice)) {
                boolean checkIdCus = false;
                for (Customer customer : customerList) {
                    if (customer.getIdCus().equals(idCus)) {
                        customerNew = new Customer(customer.getIdCus(), customer.getNameCustomer(), customer.getBirthday(),
                                customer.getGender(), customer.getCmnd(), customer.getPhoneNumber(), customer.getEmail(),
                                customer.getCustomerType(), customer.getAddress(), villa);
                        ReadWriteBooking.writeBookingVilla(customerNew);
                        checkIdCus = true;
                        break;
                    }
                }
                checkIdVilla = checkIdCus;
                break;
            }
        }
        if (checkIdVilla) {
            System.out.println("Nhập thành công");
        } else {
            System.out.println("Nhập sai ID khách hoặc villa sai, vui lòng nhập lại");
        }
    }

    public static void bookingHouse() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        ShowInfoCustomer.showInfoCustomer();
        ShowService.showAllHouse();
        System.out.println("Nhập ID Customer: ");
        String idCus = scanner.nextLine();
        System.out.println("Chọn ID phòng: ");
        String choice = scanner.nextLine();
        boolean checkIdHouse = false;
        Customer customerNew;
        for (House house : houseList) {
            if (house.getId().equals(choice)) {
                boolean checkIdCus = false;
                for (Customer customer : customerList) {
                    if (customer.getIdCus().equals(idCus)) {
                        customerNew = new Customer(customer.getIdCus(), customer.getNameCustomer(), customer.getBirthday(),
                                customer.getGender(), customer.getCmnd(), customer.getPhoneNumber(), customer.getEmail(),
                                customer.getCustomerType(), customer.getAddress(), house);
                        ReadWriteBooking.writeBookingHouse(customerNew);
                        checkIdCus = true;
                        break;
                    }
                }
                checkIdHouse = checkIdCus;
                break;
            }
        }
        if (checkIdHouse) {
            System.out.println("Nhập thành công");
        } else {
            System.out.println("Nhập sai ID khách hoặc House sai, vui lòng nhập lại");
        }
    }

    public static void bookingRoom() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        ShowInfoCustomer.showInfoCustomer();
        ShowService.showAllRoom();
        System.out.println("Nhập ID Customer: ");
        String idCus = scanner.nextLine();
        System.out.println("Chọn ID phòng: ");
        String choice = scanner.nextLine();
        boolean checkIdRoom = false;
        Customer customerNew;
        for (Room room : roomList) {
            if (room.getId().equals(choice)) {
                boolean checkIdCus = false;
                for (Customer customer : customerList) {
                    if (customer.getIdCus().equals(idCus)) {
                        customerNew = new Customer(customer.getIdCus(), customer.getNameCustomer(), customer.getBirthday(),
                                customer.getGender(), customer.getCmnd(), customer.getPhoneNumber(), customer.getEmail(),
                                customer.getCustomerType(), customer.getAddress(), room);
                        ReadWriteBooking.writeBookingRoom(customerNew);
                        checkIdCus = true;
                        break;
                    }
                }
                checkIdRoom = checkIdCus;
                break;
            }
        }
        if (checkIdRoom) {
            System.out.println("Nhập thành công");
        } else {
            System.out.println("Nhập sai ID khách hoặc Room sai, vui lòng nhập lại");
        }
    }
}
