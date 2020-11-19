package case_study_module_2.controllers;

import case_study_module_2.commons.*;
import case_study_module_2.models.*;

import java.util.*;

public class MainController {

    Scanner scanner = new Scanner(System.in);

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
                showInfoCustomer();
                displayMainMenu();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showInfoEmployee();
                System.out.println("--------------");
                displayMainMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                displayMainMenu();
                break;
        }
    }

    public void showInfoEmployee(){
        Map<String,Employee> mapEmployee = ReadWriteEmployee.readEmployee();
        for (Map.Entry<String, Employee> entry : mapEmployee.entrySet()) {
            System.out.println("Mã số: " + entry.getKey() + " , " + entry.getValue());
        }
    }

    public void addNewBooking() {
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
                displayMainMenu();
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                addNewBooking();
                break;
        }
    }

    public void bookingVilla() {
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        showInfoCustomer();
        showAllVilla();
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
                        new ReadWriteBooking().writeBookingVilla(customerNew);
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

    public void bookingHouse() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        showInfoCustomer();
        showAllHouse();
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
                        new ReadWriteBooking().writeBookingHouse(customerNew);
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

    public void bookingRoom() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        List<Customer> customerList = ReadWriteCustomer.readCustomer();
        scanner.nextLine();
        showInfoCustomer();
        showAllRoom();
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
                        new ReadWriteBooking().writeBookingRoom(customerNew);
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

    public void showInfoCustomer() {
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

    public void addNewCustomer() {
        Customer customer = new Customer();
        scanner.nextLine();
        boolean check = false;
        do {
            try{
                System.out.println("Nhập số ID: ");
                String idCus = scanner.nextLine();
                if (ValidateData.validateCmndCustomer(idCus)){
                    customer.setIdCus(idCus);
                    check = true;
                } else {
                    throw new IdCardException("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
                }
            } catch (IdCardException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập họ và tên: ");
                String nameCustomer = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCustomer.trim())){
                    customer.setNameCustomer(nameCustomer.trim());
                    check = true;
                } else {
                    throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
                }
            } catch (NameException e){
                System.err.println(e.getMessage());
            }
        } while (!check);

        System.out.println("Nhập ngày sinh: ");
        customer.setBirthday(scanner.nextLine());
        check = false;
        do {
            try {
                System.out.println("Nhập giới tính: ");
                String gender = scanner.nextLine();
                if (ValidateData.validateGenderCustomer(gender)){
                    String[] str = (gender.toLowerCase()).split("");
                    StringBuilder genderNew = new StringBuilder(str[0].toUpperCase());
                    for ( int i = 1; i < str.length; i++){
                        genderNew.append(str[i]);
                    }
                    customer.setGender(genderNew.toString());
                    check = true;
                } else {
                    throw new GenderException("Nhập sai giới tính , phải là male, female hoặc unknow");
                }
            }catch (GenderException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try{
                System.out.println("Nhập số CMND: ");
                String cmnd = scanner.nextLine();
                if (ValidateData.validateCmndCustomer(cmnd)){
                    customer.setCmnd(cmnd);
                    check = true;
                } else {
                    throw new IdCardException("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
                }
            } catch (IdCardException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                String phoneNumber = scanner.nextLine();
                if (ValidateData.validatePhoneCustomer(phoneNumber)) {
                    customer.setPhoneNumber(phoneNumber);
                    check = true;
                } else {
                    throw new PhoneNumberException("Số điện thoại chỉ có 10 số");
                }
            } catch (PhoneNumberException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try {
                System.out.println("Nhập email: ");
                String email = scanner.nextLine();
                if (ValidateData.validateEmailCustomer(email)){
                    customer.setEmail(email);
                    check = true;
                } else {
                    throw new EmailException("Email phải đúng định dạng abc@abc.abc");
                }
            } catch (EmailException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.println("Nhập loại khách: ");
        customer.setCustomerType(scanner.nextLine());
        System.out.println("Nhập địa chỉ: ");
        customer.setAddress(scanner.nextLine());
        System.out.println("Bạn đã nhập thành công");
        ReadWriteCustomer.writeCustomerInfo(customer);
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
        switch (choose) {
            case 1:
                showAllVilla();
                showServices();
                break;
            case 2:
                showAllHouse();
                showServices();
                break;
            case 3:
                showAllRoom();
                showServices();
                break;
            case 4:
                showNameVillaNotDuplicate();
                showServices();
                break;
            case 5:

                showNameHouseNotDuplicate();
                showServices();
                break;
            case 6:
                showNameRoomNotDuplicate();
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

    public void addVilla() {
        Villa villa = new Villa();
        boolean check = false;
        do {
            System.out.println("Nhập ID: ");
            String idTest = scanner.nextLine();
            if (ValidateData.validateIdServiceVilla(idTest)){
                villa.setId(idTest);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                villa.setServiceName(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập diện tích thuê:");
            String areaRent = scanner.nextLine();
            if (ValidateData.validatePoolArea(areaRent)) {
                villa.setAreaRent(areaRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập giá thuê:");
            String priceRent = scanner.nextLine();
            if (ValidateData.validatePriceRent(priceRent)) {
                villa.setPriceRent(priceRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số lượng tối đa:");
            String amountMax = scanner.nextLine();
            if (ValidateData.validateAmountMax(amountMax)) {
                villa.setAmountMax(amountMax);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập kiểu thuê: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                villa.setRentType(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                villa.setRoomStandar(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);

        check = false;
        do {
            System.out.println("Nhập tiện nghi khác: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                villa.setOtherFacilities(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập diện tích hồ bơi: ");
            String areaRent = scanner.nextLine();
            if (ValidateData.validatePoolArea(areaRent)) {
                villa.setPoolArea(areaRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số tầng:");
            String numFloor = scanner.nextLine();
            if (Integer.parseInt(numFloor) > 1) {
                villa.setNumFloors(numFloor);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        System.out.println("Bạn đã nhập thành công");
        ReadWriteVillaInfoToFileCsv.writeVillaInfoToFileCsv(villa);
    }

    public void addHouse() {
        House house = new House();
        boolean check = false;
        do {
            System.out.println("Nhập ID: ");
            String idTest = scanner.nextLine();
            if (ValidateData.validateIdServiceHouse(idTest)){
                house.setId(idTest);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                house.setServiceName(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập diện tích thuê:");
            String areaRent = scanner.nextLine();
            if (ValidateData.validatePoolArea(areaRent)) {
                house.setAreaRent(areaRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập giá thuê:");
            String priceRent = scanner.nextLine();
            if (ValidateData.validatePriceRent(priceRent)) {
                house.setPriceRent(priceRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số lượng tối đa:");
            String amountMax = scanner.nextLine();
            if (ValidateData.validateAmountMax(amountMax)) {
                house.setAmountMax(amountMax);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập kiểu thuê: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                house.setRentType(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                house.setRoomStandard(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);

        check = false;
        do {
            System.out.println("Nhập tiện nghi khác: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                house.setOtherFacilities(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số tầng:");
            String numFloor = scanner.nextLine();
            if (Integer.parseInt(numFloor) > 1) {
                house.setNumFloors(numFloor);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        System.out.println("Bạn đã nhập thành công");
        ReadWriteHouseInfoToFileCsv.writeHouseInfoToFileCsv(house);
    }

    public void addRoom() {
        Room room = new Room();
        boolean check = false;
        do {
            System.out.println("Nhập ID: ");
            String idTest = scanner.nextLine();
            if (ValidateData.validateIdServiceRoom(idTest)){
                room.setId(idTest);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                room.setServiceName(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập diện tích thuê:");
            String areaRent = scanner.nextLine();
            if (ValidateData.validatePoolArea(areaRent)) {
                room.setAreaRent(areaRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập giá thuê:");
            String priceRent = scanner.nextLine();
            if (ValidateData.validatePriceRent(priceRent)) {
                room.setPriceRent(priceRent);
                check = true;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập số lượng tối đa:");
            String amountMax = scanner.nextLine();
            if (ValidateData.validateAmountMax(amountMax)) {
                room.setAmountMax(amountMax);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập kiểu thuê: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                room.setRentType(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        check = false;
        do {
            System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
            String serviceName = scanner.nextLine();
            if (ValidateData.validateNameService(serviceName)){
                room.setFreeService(serviceName);
                check = true;
            } else {
                System.out.println("Vui lòng nhập lại");
            }
        } while (!check);
        System.out.println("Bạn đã nhập thành công");
        ReadWriteRoomInfoToFileCsv.writeRoomInfoToFileCsv(room);
    }

    public void showAllVilla() {
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        if (villaList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Villa villa : villaList) {
                villa.showInfor();
            }
        }
    }

    public void showAllHouse() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        if (houseList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (House house : houseList) {
                house.showInfor();
            }
        }
    }

    public void showAllRoom() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        if (roomList.isEmpty()) {
            System.out.println("Danh sách trống ");
        } else {
            for (Room room : roomList) {
                room.showInfor();
            }
        }
    }

    public void showNameVillaNotDuplicate() {
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        Set<String> treeVilla = new TreeSet<>();
        if (villaList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Villa v : villaList) {
                treeVilla.add(v.getServiceName());
            }
            System.out.println(treeVilla);
        }
    }

    public void showNameHouseNotDuplicate() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        Set<String> treeHouse = new TreeSet<>();
        if (houseList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (House h : houseList) {
                treeHouse.add(h.getServiceName());
            }
            System.out.println(treeHouse);
        }
    }

    public void showNameRoomNotDuplicate() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        Set<String> treeRoom = new TreeSet<>();
        if (roomList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Room r : roomList) {
                treeRoom.add(r.getServiceName());
            }
            System.out.println(treeRoom);
        }
    }
}