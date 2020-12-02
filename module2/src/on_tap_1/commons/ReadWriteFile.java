package on_tap_1.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void writeFile(String line){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                    (new File("src/on_tap_1/data/products.csv"), true));
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void creatFile(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                    (new File("src/on_tap_1/data/products.csv"), false));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readFile() {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/on_tap_1/data/products.csv");
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
