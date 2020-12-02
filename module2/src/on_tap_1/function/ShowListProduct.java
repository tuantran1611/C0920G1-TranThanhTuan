package on_tap_1.function;

import on_tap_1.commons.ReadWriteFile;
import on_tap_1.models.ProductExport;
import on_tap_1.models.SoDaiHan;

import java.util.List;

public class ShowListProduct {
    public static void showListProduct(){
        List<String[]> listString = ReadWriteFile.readFile();
        if (listString.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (String[] list : listString){
                if (list.length == 8){
                    System.out.println(new ProductExport(Integer.parseInt(list[0]),list[1],list[2],list[3],list[4],
                            list[5],list[6],list[7]).toString());
                } else {
                    System.out.println(new SoDaiHan(Integer.parseInt(list[0]),list[1],list[2],list[3],list[4],
                            list[5],list[6],list[7],list[8]).toString());
                }
            }
        }
    }
}
