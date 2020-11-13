package _16_io_text_file.exercise.bt_2_optional;

import java.io.*;

public class DisplayCountry {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(new File("src/_16_io_text_file/exercise/bt_2_optional/country.csv")));
            String line;
            String[] strArr;
            while ((line = bufferedReader.readLine()) != null){
                strArr = line.split(",");
                System.out.println(strArr[5]);
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
