package exam_2.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteSo {
    public static void writeFile(String filePath ,String line){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                    (new File(filePath), true));
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void creatFile(String filePath){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                    (new File(filePath), false));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] elementLine = line.split(",");
                list.add(elementLine);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
