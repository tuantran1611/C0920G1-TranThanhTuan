package on_tap_1.function;

import on_tap_1.commons.ReadWriteFile;
import on_tap_1.models.ProductExport;
import on_tap_1.models.SoDaiHan;

import java.util.List;
import java.util.Scanner;

public class SearchProduct {
    static Scanner scanner = new Scanner(System.in);
    public static void searchProduct(){
        boolean check = false;
        List<String[]> listString = ReadWriteFile.readFile();
        System.out.println("Nhập mã sản phẩm hoặc tên sản phẩm muốn tìm");
        String searchProduct = scanner.nextLine();
        for (String[] list : listString){
            if (list[0].contains(searchProduct) | list[1].contains(searchProduct)) {
                if (list.length == 8) {
                    System.out.println(new ProductExport(Integer.parseInt(list[0]), list[1], list[2], list[3], list[4],
                            list[5], list[6], list[7]).toString());
                } else {
                    System.out.println(new SoDaiHan(Integer.parseInt(list[0]), list[1], list[2], list[3], list[4],
                            list[5], list[6], list[7], list[8]).toString());
                }
                check = true;
            }
        }
        if (!check){
            System.out.println("Sản phẩm bạn tìm không tồn tại");
        }
    }
}
