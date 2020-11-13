package _16_io_text_file.exercise.bt_1;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        try {
            File inFile = new File("src/_16_io_text_file/exercise/bt_1/test.txt");
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            FileWriter fileWriter = new FileWriter("src/_16_io_text_file/exercise/bt_1/testcopy.txt");
            while ((line = reader.readLine()) != null){
                fileWriter.write(line);
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
