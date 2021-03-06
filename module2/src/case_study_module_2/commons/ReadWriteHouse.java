package case_study_module_2.commons;

import case_study_module_2.models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteHouse {
    private static final String HOUSE_PATH = "src/case_study_module_2/data/House.csv";

    static File file = new File(HOUSE_PATH);

    public static void creatFileCsv(){
        try {
            new BufferedWriter(new FileWriter(
                    file , false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHouseInfoToFileCsv(House h){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(
                    file , true));
            br.write(h.getId() + "," + h.getServiceName() + "," +
                    h.getAreaRent() + "," + h.getPriceRent() + "," +
                    h.getAmountMax() + "," + h.getRentType() + "," +
                    h.getRoomStandard() + "," +
                    h.getOtherFacilities() + "," +  h.getNumFloors());
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readHouse(){
        List<House> houses = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(HOUSE_PATH)));
            String[] strArr;
            String line;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                House house = new House(strArr[0], strArr[1],strArr[2], strArr[3],
                        strArr[4], strArr[5], strArr[6], strArr[7],strArr[8]);
                houses.add(house);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houses;
    }
}
