package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteHouse;
import case_study_module_2.commons.ReadWriteRoom;
import case_study_module_2.commons.ReadWriteVilla;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteServices {
    static Scanner scanner = new Scanner(System.in);

    public static void deleteServices() {
        System.out.println("1. Delete Villa\n" +
                "2. Delete House\n" +
                "3. Delete Room\n" +
                "4. Back to menu\n" +
                "5. Exit"
        );
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                deleteVilla();
                deleteServices();
                break;
            case 2:
                deleteHouse();
                deleteServices();
                break;
            case 3:
                deleteRoom();
                deleteServices();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại!!!");
                deleteServices();
                break;
        }
    }

    public static void deleteVilla() {
        List<Villa> villaList = ReadWriteVilla.readVilla();
        if (villaList.isEmpty()) {
            ShowService.showAllVilla();
        } else {
            ShowService.showAllVilla();
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (Villa villa : villaList) {
                if (idEdit.equals(villa.getId())) {
                    villaList.remove(villa);
                    break;
                }
            }
            if (villaList.size() == 0){
                ReadWriteVilla.creatFileCsv();
            } else {
                ReadWriteVilla.creatFileCsv();
                for (Villa villa : villaList) {
                    ReadWriteVilla.writeVillaInfoToFileCsv(villa);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

    public static void deleteHouse() {
        List<House> houseList = ReadWriteHouse.readHouse();
        if (houseList.isEmpty()) {
            ShowService.showAllHouse();
        } else {
            ShowService.showAllHouse();
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (House house : houseList) {
                if (idEdit.equals(house.getId())) {
                    houseList.remove(house);
                    break;
                }
            }
            if (houseList.size() == 0){
                ReadWriteHouse.creatFileCsv();
            } else {
                ReadWriteHouse.creatFileCsv();
                for (House house : houseList) {
                    ReadWriteHouse.writeHouseInfoToFileCsv(house);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

    public static void deleteRoom() {
        List<Room> roomList = ReadWriteRoom.readRoom();
        if (roomList.isEmpty()) {
            ShowService.showAllRoom();
        } else {
            ShowService.showAllRoom();
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (Room room : roomList) {
                if (idEdit.equals(room.getId())) {
                    roomList.remove(room);
                    break;
                }
            }
            if (roomList.size() == 0){
                ReadWriteRoom.creatFileCsv();
            } else {
                ReadWriteRoom.creatFileCsv();
                for (Room room : roomList) {
                    ReadWriteRoom.writeRoomInfoToFileCsv(room);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

}