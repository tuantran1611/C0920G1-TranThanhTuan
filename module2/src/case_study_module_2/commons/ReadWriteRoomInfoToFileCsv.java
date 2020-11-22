package case_study_module_2.commons;

import case_study_module_2.models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteRoomInfoToFileCsv {

    private static final String ROOM_PATH  = "src/case_study_module_2/data/Room.csv";

    public static void creatFileCsv(){
        try {
            new BufferedWriter(new FileWriter(
                    new File(ROOM_PATH),false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRoomInfoToFileCsv(Room r){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(
                    new File(ROOM_PATH),true));
            br.write(r.getId() + "," + r.getServiceName() + "," +
                    r.getAreaRent() + "," + r.getPriceRent() + "," +
                    r.getAmountMax() + "," + r.getRentType() + "," +
                    r.getFreeService());
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> readRoom(){
        List<Room> rooms = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(ROOM_PATH)));
            String[] strArr = null;
            String line = null;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                Room room = new Room(strArr[0], strArr[1],strArr[2], strArr[3],
                        strArr[4], strArr[5], strArr[6]);
                rooms.add(room);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
