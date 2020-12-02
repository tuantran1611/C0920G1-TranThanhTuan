package exam_2.function;

import exam_2.commons.ReadWriteSo;
import exam_2.models.SoDaiHan;
import exam_2.models.SoNganHan;
import exam_2.models.SoVoHan;

import java.util.List;

public class XemDanhSachSoTietKiem {

    public static void xemDanhSachSo() {
        List<String[]> listString1 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath1());
        List<String[]> listString2 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath2());
        if (listString1.isEmpty()) {
            System.out.println("Danh sách sổ dài hạn trống");
        } else {
            for (String[] list : listString1) {
                System.out.println(new SoDaiHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                        list[5], list[6], list[7]).toString());
            }
        }
        if (listString2.isEmpty()){
            System.out.println("Danh sách sổ có thời hạn trống");
        } else {
            for (String[] list : listString1) {
                if (list.length == 7) {
                    System.out.println(new SoNganHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                            list[5], list[6]).toString());
                } else {
                    System.out.println(new SoVoHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                            list[5]).toString());
                }
            }
        }
    }
}
