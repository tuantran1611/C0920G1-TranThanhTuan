package case_study_module_2.commons;

import case_study_module_2.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteVilla {
    private static final String VILLA_PATH  = "src/case_study_module_2/data/Villa.csv";

    public static void creatFileCsv(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    new File(VILLA_PATH),false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVillaInfoToFileCsv(Villa v){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    new File(VILLA_PATH),true));
            bw.write(v.getId() + "," + v.getServiceName() + "," +
                        v.getAreaRent() + "," + v.getPriceRent() + "," +
                        v.getAmountMax() + "," + v.getRentType() + "," +
                        v.getRoomStandar() + "," + v.getOtherFacilities() + "," +
                        v.getPoolArea() + "," + v.getNumFloors());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Villa> readVilla(){
        List<Villa> villas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader( new File (VILLA_PATH)));
            String[] strArr;
            String line ;
            Villa villa;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                villa = new Villa(strArr[0],strArr[1],strArr[2], strArr[3],
                        strArr[4],strArr[5],strArr[6],strArr[7],strArr[8],strArr[9]);
                villas.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villas;
    }
}
