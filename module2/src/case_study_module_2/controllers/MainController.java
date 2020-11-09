package case_study_module_2.controllers;

import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.*;

public class MainController {
    List<Villa> villas = new ArrayList<>();
    List<House> houses = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    TreeSet<Villa> treeVilla = new TreeSet<>();
    TreeSet<House> treeHouse = new TreeSet<>();
    TreeSet<Room> treeRoom = new TreeSet<>();

    public void displayMainMenu() {
        System.out.println("1. Add new services\n" +
                "2. Show services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Exit"
        );
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
//            case 3:
//                addNewCustomer();
//                break;
//            case 4:
//                showInfoCustomer();
//                break;
        }
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
                villas.add(addInfoVilla());
                System.out.println("Bạn đã nhập thành công");
                displayMainMenu();
                break;
            case 2:
                houses.add(addInfoHouse());
                System.out.println("Bạn đã nhập thành công");
                displayMainMenu();
                break;
            case 3:
                rooms.add(addInfoRoom());
                System.out.println("Bạn đã nhập thành công");
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
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                showNameVillaNotDuplicate();
                break;
            case 5:
                showNameHouseNotDuplicate();
                break;
            case 6:
                showNameRoomNotDuplicate();
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
    public Villa addInfoVilla(){
        Villa villa = new Villa();
        System.out.println("Nhập ID: ");
        villa.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        villa.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        villa.setAreaRent(scanner.nextDouble());
        System.out.println("Nhập giá thuê:");
        villa.setPriceRent(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập số lượng tối đa:");
        villa.setAmountMax(scanner.nextInt());
        System.out.println("Nhập kiểu thuê:");
        scanner.nextLine();
        villa.setRentType(scanner.nextLine());
        System.out.println("Nhập tiêu chuẩn phòng:");
        villa.setRoomStandar(scanner.nextLine());
        System.out.println("Nhập tiện ích khác:");
        villa.setOtherFacilities(scanner.nextLine());
        System.out.println("Nhập diện tích hồ bơi:");
        villa.setPoolArea(scanner.nextDouble());
        System.out.println("Nhập số tầng:");
        villa.setNumFloors(scanner.nextInt());
        return villa;
    }

    public House addInfoHouse(){
        House house = new House();
        System.out.println("Nhập ID: ");
        house.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        house.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        house.setAreaRent(scanner.nextDouble());
        System.out.println("Nhập giá thuê:");
        house.setPriceRent(scanner.nextInt());
        System.out.println("Nhập số lượng tối đa:");
        house.setAmountMax(scanner.nextInt());
        System.out.println("Nhập kiểu thuê:");
        scanner.nextLine();
        house.setRentType(scanner.nextLine());
        System.out.println("Nhập tiêu chuẩn phòng:");
        house.setRoomStandard(scanner.nextLine());
        System.out.println("Nhập tiện ích khác:");
        house.setOtherFacilities(scanner.nextLine());
        System.out.println("Nhập số tầng:");
        house.setNumFloors(scanner.nextInt());
        return house;
    }

    public Room addInfoRoom(){
        Room room = new Room();
        System.out.println("Nhập ID: ");
        room.setId(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        room.setServiceName(scanner.nextLine());
        System.out.println("Nhập diện tích thuê:");
        room.setAreaRent(scanner.nextDouble());
        System.out.println("Nhập giá thuê:");
        room.setPriceRent(scanner.nextInt());
        System.out.println("Nhập số lượng tối đa:");
        room.setAmountMax(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập kiểu thuê:");
        room.setRentType(scanner.nextLine());
        System.out.println("Nhập dịch vụ miễn phí đi kèm:");
        room.setFreeService(scanner.nextLine());
        return room;
    }

    public void showAllVilla(){
        if (villas.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (Villa villa : villas){
                villa.showInfor();
            }
        }
        showServices();
    }

    public void showAllHouse(){
        if (houses.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (House house : houses){
                house.showInfor();
            }
        }
        showServices();
    }

    public void showAllRoom(){
        if (rooms.isEmpty()){
            System.out.println("Danh sách trống ");
        } else {
            for (Room room : rooms){
                room.showInfor();
            }
        }
        showServices();
    }

    public void showNameVillaNotDuplicate() {
        if (treeVilla.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            treeVilla.add((Villa) villas);
            System.out.println(treeVilla);
        }
        showServices();
    }

    public void showNameHouseNotDuplicate() {
        if (treeHouse.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            treeHouse.add((House) houses);
            System.out.println(treeHouse);
        }
        showServices();
    }

    public void showNameRoomNotDuplicate() {
        if (treeRoom.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            treeRoom.add((Room) rooms);
            System.out.println(treeRoom);
        }
        showServices();
    }

}
