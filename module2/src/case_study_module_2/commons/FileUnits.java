package case_study_module_2.commons;

import case_study_module_2.models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUnits {
    public static void writeCsv(String filePath, String line, boolean append){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    filePath , append));
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readCsv(String filePath){
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


}
