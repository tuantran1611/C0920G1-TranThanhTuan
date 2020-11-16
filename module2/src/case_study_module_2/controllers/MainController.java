package case_study_module_2.controllers;

import case_study_module_2.commons.*;
import case_study_module_2.models.*;

import java.util.*;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    List<Villa> villaList = new ReadWriteVillaInfoToFileCsv().readVilla();
    List<House> houseList = new ReadWriteHouseInfoToFileCsv().readHouse();
    List<Room> roomList = new ReadWriteRoomInfoToFileCsv().readRoom();
    List<Customer> customerList = new ReadWriteCustomer().readCustomer();
    Set<String> treeVilla = new TreeSet<>();
    Set<String> treeHouse = new TreeSet<>();
    Set<String> treeRoom = new TreeSet<>();


    public void displayMainMenu() {
        System.out.println("1. Add new services\n" +
                "2. Show services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Exit"
        );
        switch (scanner.nextInt()) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                displayMainMenu();
                break;
            case 4:
                showInfoCustomer(customerList);
                displayMainMenu();
                break;
            case 5:
                addNewBooking();
                break;
//            case 6:
//                showInfoEmployee();
//                break;
        }
    }

    public void addNewBooking(){
        showInfoCustomer(customerList);
        System.out.println("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Back to menu\n");
        switch (scanner.nextInt()){
            case 1:
                bookingVilla();
                addNewServices();
                break;
        }
    }

    public void bookingVilla(){
        showInfoCustomer(customerList);
        System.out.println("Nhập ID Customer: ");
        String idCus = scanner.nextLine();
        showAllVilla(villaList);
        System.out.println("Chọn ID phòng: ");
        String choice = scanner.nextLine();
        boolean check = false;
        Customer customerNew;
        for (Villa villa : villaList){
            if (choice.equals(villa.getId())){
                for (Customer customer : customerList){
                    if (idCus.equals(customer.getIdCus())) {
                        customerNew = new Customer(customer.getIdCus(), customer.getNameCustomer(), customer.getBirthday(),
                                customer.getGender(), customer.getCmnd(), customer.getPhoneNumber(), customer.getEmail(),
                                customer.getCustomerType(), customer.getAddress(), villa);
                                new ReadWriteBooking().writeBooking(customerNew);
                    } else {
                        System.out.println("Vui lòng nhập lại");
                        bookingVilla();
                    }
                    break;
                }
            }
            check = true;
            break;
        }
        if (check){
            System.out.println("Nhập thành công");
        } else {
            System.out.println("Vui lòng nhập lại");
            bookingVilla();
        }
    }

    public void showInfoCustomer(List<Customer> customers){
        customers.sort(new CompareBirthDayCustomer());
        if (customers.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (Customer customer : customers) {
                customer.showInfo();
            }
        }
    }

    public void addNewCustomer(){
        Customer customer = new Customer();
        System.out.println("Nhập ID khách hàng: ");
        customer.setNameCustomer(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Nhập họ và tên: ");
        customer.setNameCustomer(scanner.nextLine());
        System.out.println("Nhập ngày sinh: ");
        customer.setBirthday(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        customer.setGender(scanner.nextLine());
        System.out.println("Nhập số CMND: ");
        customer.setCmnd(scanner.nextLine());
        System.out.println("Nhập số điện thoại: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.println("Nhập email: ");
        customer.setEmail(scanner.nextLine());
        System.out.println("Nhập loại khách: ");
        customer.setCustomerType(scanner.nextLine());
        System.out.println("Nhập địa chỉ: ");
        customer.setAddress(scanner.nextLine());
        System.out.println("Bạn đã nhập thành công");
        new ReadWriteCustomer().writeCustomerInfo(customer);
    }

    public void addNewServices() {
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit"
        );
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                addVilla();
                displayMainMenu();
                break;
            case 2:
                addHouse();
                displayMainMenu();
                break;
            case 3:
                addRoom();
                displayMainMenu();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại!!!");
                addNewServices();
                break;
        }
    }

    public void showServices(){
        System.out.println("1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicaten\n" +
                "6. Show All Name Name Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit"
        );
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                showAllVilla(villaList);
                showServices();
                break;
            case 2:
                showAllHouse(houseList);
                showServices();
                break;
            case 3:
                showAllRoom(roomList);
                showServices();
                break;
            case 4:
                showNameVillaNotDuplicate(villaList);
                showServices();
                break;
            case 5:
                showNameHouseNotDuplicate(houseList);
                showServices();
                break;
            case 6:
                showNameRoomNotDuplicate(roomList);
                showServices();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại !!!");
                showServices();
                break;
        }
    }

    public void addVilla(){
        Villa villa = new Villa();
        System.out.println("Nhập ID: ");
        villa.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        villa.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        villa.setAreaRent(scanner.nextLine());
        System.out.println("Nhập giá thuê:");
        villa.setPriceRent(scanner.nextLine());
        System.out.println("Nhập số lượng tối đa:");
        villa.setAmountMax(scanner.nextLine());
        System.out.println("Nhập kiểu thuê:");
        villa.setRentType(scanner.nextLine());
        System.out.println("Nhập tiêu chuẩn phòng:");
        villa.setRoomStandar(scanner.nextLine());
        System.out.println("Nhập tiện ích khác:");
        villa.setOtherFacilities(scanner.nextLine());
        System.out.println("Nhập diện tích hồ bơi:");
        villa.setPoolArea(scanner.nextLine());
        System.out.println("Nhập số tầng:");
        villa.setNumFloors(scanner.nextLine());
        System.out.println("Bạn đã nhập thành công");
        new ReadWriteVillaInfoToFileCsv().writeVillaInfoToFileCsv(villa);
    }

    public void addHouse(){
        House house = new House();
        System.out.println("Nhập ID: ");
        house.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        house.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        house.setAreaRent(scanner.nextLine());
        System.out.println("Nhập giá thuê:");
        house.setPriceRent(scanner.nextLine());
        System.out.println("Nhập số lượng tối đa:");
        house.setAmountMax(scanner.nextLine());
        System.out.println("Nhập kiểu thuê:");
        house.setRentType(scanner.nextLine());
        System.out.println("Nhập tiêu chuẩn phòng:");
        house.setRoomStandard(scanner.nextLine());
        System.out.println("Nhập tiện ích khác:");
        house.setOtherFacilities(scanner.nextLine());
        System.out.println("Nhập số tầng:");
        house.setNumFloors(scanner.nextLine());
        System.out.println("Bạn đã nhập thành công");
        new ReadWriteHouseInfoToFileCsv().writeHouseInfoToFileCsv(house);
    }

    public void addRoom(){
        Room room = new Room();
        System.out.println("Nhập ID: ");
        room.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        room.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        room.setAreaRent(scanner.nextLine());
        System.out.println("Nhập giá thuê:");
        room.setPriceRent(scanner.nextLine());
        System.out.println("Nhập số lượng tối đa:");
        room.setAmountMax(scanner.nextLine());
        System.out.println("Nhập kiểu thuê:");
        room.setRentType(scanner.nextLine());
        System.out.println("Nhập dịch vụ miễn phí đi kèm:");
        room.setFreeService(scanner.nextLine());
        System.out.println("Bạn đã nhập thành công");
        new ReadWriteRoomInfoToFileCsv().writeRoomInfoToFileCsv(room);
    }

    public void showAllVilla(List<Villa> villas){
        if (villas.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (Villa villa : villas){
                villa.showInfor();
            }
        }
    }

    public void showAllHouse(List<House> houses){
        if (houses.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (House house : houses){
                house.showInfor();
            }
        }
    }

    public void showAllRoom(List<Room> rooms){
        if (rooms.isEmpty()){
            System.out.println("Danh sách trống ");
        } else {
            for (Room room : rooms){
                room.showInfor();
            }
        }
    }

    public void showNameVillaNotDuplicate(List<Villa> villas) {
        if (treeVilla.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Villa v : villas){
                treeVilla.add(v.getServiceName());
            }
            System.out.println(treeVilla);
        }
    }

    public void showNameHouseNotDuplicate(List<House> houses) {
        if (treeHouse.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (House h : houses){
                treeHouse.add(h.getServiceName());
            }
            System.out.println(treeHouse);
        }
    }

    public void showNameRoomNotDuplicate(List<Room> rooms) {
        if (treeRoom.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Room r : rooms){
                treeRoom.add(r.getServiceName());
            }
            System.out.println(treeRoom);
        }
    }
}
