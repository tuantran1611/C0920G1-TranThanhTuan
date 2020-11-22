package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteHouseInfoToFileCsv;
import case_study_module_2.commons.ReadWriteRoomInfoToFileCsv;
import case_study_module_2.commons.ReadWriteVillaInfoToFileCsv;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ShowService {
    static Scanner scanner = new Scanner(System.in);
    public static void showServices(){
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
                MainController.displayMainMenu();
                break;
            case 8:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại !!!");
                showServices();
                break;
        }
    }
    public static void showAllVilla() {
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        if (villaList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Villa villa : villaList) {
                villa.showInfor();
            }
        }
    }

    public static void showAllHouse() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        if (houseList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (House house : houseList) {
                house.showInfor();
            }
        }
    }

    public static void showAllRoom() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        if (roomList.isEmpty()) {
            System.out.println("Danh sách trống ");
        } else {
            for (Room room : roomList) {
                room.showInfor();
            }
        }
    }

    public static void showNameVillaNotDuplicate() {
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

    public static void showNameHouseNotDuplicate() {
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

    public static void showNameRoomNotDuplicate() {
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
