package exam_2.function;

import exam_2.commons.ReadWriteSo;
import exam_2.commons.RegexData;
import exam_2.models.SoDaiHan;
import exam_2.models.SoNganHan;
import exam_2.models.SoVoHan;

import java.util.List;
import java.util.Scanner;

public class TimKiemSoTietKiem {
    static Scanner scanner = new Scanner(System.in);

    public static void timKiemSoTietKiem() {
        List<String[]> listString1 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath1());
        List<String[]> listString2 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath2());
        boolean check = false;
        boolean isList1 = false;
        if (listString1.isEmpty() && listString2.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            do {
                System.out.println("Nhập mã sổ muốn tìm");
                String maSoXoa = scanner.nextLine();

                if (RegexData.regexMaSoSo(maSoXoa)) {
                    for (String[] list : listString1) {
                        if (list[0].contains(maSoXoa)) {
                            System.out.println(new SoDaiHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                                    list[5], list[6], list[7]).toString());
                            check = true;
                            isList1 = true;
                            break;
                        }
                    }
                    if (!isList1) {
                        for (String[] list : listString2) {
                            if (list[0].contains(maSoXoa)) {
                                if (list.length == 7) {
                                    System.out.println(new SoNganHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                                            list[5], list[6]).toString());
                                } else {
                                    System.out.println(new SoVoHan(list[0], Integer.parseInt(list[1]), list[2], list[3], list[4],
                                            list[5]).toString());
                                }
                                check = true;
                                break;
                            }
                        }
                    }
                }

                if (!check) {
                    System.out.println(("Sản phẩm không tồn tại"));
                }
            } while (!check);
        }
    }
}
