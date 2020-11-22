package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteHouseInfoToFileCsv;
import case_study_module_2.commons.ReadWriteRoomInfoToFileCsv;
import case_study_module_2.commons.ReadWriteVillaInfoToFileCsv;
import case_study_module_2.commons.ValidateData;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.Scanner;

public class AddNewServices {
    static Scanner scanner = new Scanner(System.in);
    public static void addNewServices() {
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
                MainController.displayMainMenu();
                break;
            case 2:
                addHouse();
                MainController.displayMainMenu();
                break;
            case 3:
                addRoom();
                MainController.displayMainMenu();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại!!!");
                addNewServices();
                break;
        }
    }

    public static void addVilla() {
        Villa villa = new Villa();
        System.out.println("Bạn đã nhập thành công");
        ReadWriteVillaInfoToFileCsv.writeVillaInfoToFileCsv(addVillaInfo(villa));
    }

    public static void addHouse() {
        House house = new House();
        System.out.println("Bạn đã nhập thành công");
        ReadWriteHouseInfoToFileCsv.writeHouseInfoToFileCsv(addHouseInfo(house));
    }

    public static void addRoom() {
        Room room = new Room();
        System.out.println("Bạn đã nhập thành công");
        ReadWriteRoomInfoToFileCsv.writeRoomInfoToFileCsv(addRoomInfo(room));
    }
    public static Villa addVillaInfo(Villa villa){
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
        return villa;
    }

    public static House addHouseInfo(House house){
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
        return house;
    }

    public static Room addRoomInfo(Room room){
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
        return room;
    }
}
