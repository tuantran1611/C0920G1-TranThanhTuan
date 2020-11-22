package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteHouseInfoToFileCsv;
import case_study_module_2.commons.ReadWriteRoomInfoToFileCsv;
import case_study_module_2.commons.ReadWriteVillaInfoToFileCsv;
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
        List<Villa> villaList = ReadWriteVillaInfoToFileCsv.readVilla();
        if (villaList.isEmpty()) {
            ShowService.showAllVilla();
        } else {
            ShowService.showAllVilla();
            List<Villa> villas = new ArrayList<>(villaList);
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (Villa villa : villas) {
                if (idEdit.equals(villa.getId())) {
                    villas.remove(villa);
                    break;
                }
            }
            if (villaList.size() == 1){
                ReadWriteVillaInfoToFileCsv.creatFileCsv();
            } else {
                ReadWriteVillaInfoToFileCsv.creatFileCsv();
                for (Villa villa : villas) {
                    ReadWriteVillaInfoToFileCsv.writeVillaInfoToFileCsv(villa);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

    public static void deleteHouse() {
        List<House> houseList = ReadWriteHouseInfoToFileCsv.readHouse();
        if (houseList.isEmpty()) {
            ShowService.showAllHouse();
        } else {
            ShowService.showAllHouse();
            List<House> houses = new ArrayList<>(houseList);
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (House house : houses) {
                if (idEdit.equals(house.getId())) {
                    houses.remove(house);
                    break;
                }
            }
            if (houseList.size() == 1){
                ReadWriteHouseInfoToFileCsv.creatFileCsv();
            } else {
                ReadWriteHouseInfoToFileCsv.creatFileCsv();
                for (House house : houses) {
                    ReadWriteHouseInfoToFileCsv.writeHouseInfoToFileCsv(house);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

    public static void deleteRoom() {
        List<Room> roomList = ReadWriteRoomInfoToFileCsv.readRoom();
        if (roomList.isEmpty()) {
            ShowService.showAllRoom();
        } else {
            ShowService.showAllRoom();
            List<Room> rooms = new ArrayList<>(roomList);
            System.out.println("Nhập ID bạn muốn xóa");
            String idEdit = scanner.nextLine();
            for (Room room : rooms) {
                if (idEdit.equals(room.getId())) {
                    rooms.remove(room);
                    break;
                }
            }
            if (roomList.size() == 1){
                ReadWriteRoomInfoToFileCsv.creatFileCsv();
            } else {
                ReadWriteRoomInfoToFileCsv.creatFileCsv();
                for (Room room : rooms) {
                    ReadWriteRoomInfoToFileCsv.writeRoomInfoToFileCsv(room);
                }
            }
            System.out.println("Bạn đã xóa thành công");
        }
    }

}