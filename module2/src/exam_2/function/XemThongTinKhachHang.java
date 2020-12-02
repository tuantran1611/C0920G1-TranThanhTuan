package exam_2.function;

import exam_2.commons.ReadWriteSo;
import exam_2.models.KhachHang;
import exam_2.models.SoDaiHan;

import java.util.List;

public class XemThongTinKhachHang {
    static List<String[]> listString = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath3());
    public static void xemThongTinKhachHang(){
        if (listString.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (String[] list : listString) {
                System.out.println(new KhachHang(Integer.parseInt(list[0]), list[1], list[2], list[3], list[4],
                        list[5]).toString());
            }
        }
    }
}
