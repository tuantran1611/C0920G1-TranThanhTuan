package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteHouse;
import case_study_module_2.commons.ReadWriteRoom;
import case_study_module_2.commons.ReadWriteVilla;
import case_study_module_2.controllers.MainController;
import case_study_module_2.models.House;
import case_study_module_2.models.Room;
import case_study_module_2.models.Villa;

import java.util.List;
import java.util.Scanner;

public class EditServices {
    static Scanner scanner = new Scanner(System.in);

    public static void editServices() {
        System.out.println("1. Edit Villa\n" +
                "2. Edit House\n" +
                "3. Edit Room\n" +
                "4. Back to menu\n" +
                "5. Exit"
        );
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                editVilla();
                editServices();
                break;
            case 2:
                editHouse();
                editServices();
                break;
            case 3:
                editRoom();
                editServices();
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                break;
            default:
                System.out.println("Bạn nhập không đúng, vui lòng nhập lại!!!");
                editServices();
                break;
        }
    }

    public static void editVilla() {
        List<Villa> villaList = ReadWriteVilla.readVilla();
        if (villaList.isEmpty()) {
            ShowService.showAllVilla();
        } else {
            ShowService.showAllVilla();
            System.out.println("Nhập ID bạn muốn sửa");
            String idEdit = scanner.nextLine();
            for (Villa villa : villaList) {
                if (idEdit.equals(villa.getId())) {
                    AddNewServices.addVillaInfo(villa);
                    break;
                }
            }
            ReadWriteVilla.creatFileCsv();
            for (Villa villa : villaList) {
                ReadWriteVilla.writeVillaInfoToFileCsv(villa);
            }
            System.out.println("Bạn đã sửa thành công");
        }
    }

    public static void editHouse() {
        List<House> houseList = ReadWriteHouse.readHouse();
        if (houseList.isEmpty()){
            ShowService.showAllHouse();
        } else {
            ShowService.showAllHouse();
            System.out.println("Nhập ID bạn muốn sửa");
            String idEdit = scanner.nextLine();
            for (House house : houseList) {
                if (idEdit.equals(house.getId())) {
                    AddNewServices.addHouseInfo(house);
                    break;
                }
            }
            ReadWriteHouse.creatFileCsv();
            for (House house : houseList) {
                ReadWriteHouse.writeHouseInfoToFileCsv(house);
            }
            System.out.println("Bạn đã sửa thành công");
        }
    }

    public static void editRoom() {
        List<Room> roomList = ReadWriteRoom.readRoom();
        if (roomList.isEmpty()) {
            ShowService.showAllRoom();
        } else {
            ShowService.showAllRoom();
            System.out.println("Nhập ID bạn muốn sửa");
            String idEdit = scanner.nextLine();
            for (Room room : roomList) {
                if (idEdit.equals(room.getId())) {
                    AddNewServices.addRoomInfo(room);
                    break;
                }
            }
            ReadWriteRoom.creatFileCsv();
            for (Room room : roomList) {
                ReadWriteRoom.writeRoomInfoToFileCsv(room);
            }
            System.out.println("Bạn đã sửa thành công");
        }
    }
}
