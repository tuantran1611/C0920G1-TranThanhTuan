package exam_2.function;

import exam_2.commons.ReadWriteSo;
import exam_2.commons.RegexData;
import exam_2.controllers.MainControllers;
import on_tap_2.commons.NotFoundProductException;

import java.util.List;
import java.util.Scanner;

public class XoaSoTietKiem {

    static Scanner scanner = new Scanner(System.in);

    public static void xoaSoTietKiem() {
        List<String[]> listString1 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath1());
        List<String[]> listString2 = ReadWriteSo.readFile(ThemSoTietKiem.getFilePath2());
        boolean check = false;
        boolean isList1 = false;
        if (listString1.isEmpty() && listString2.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            do {
                System.out.println("Nhập mã sổ muốn xóa");
                String maSoXoa = scanner.nextLine();
                try {
                    if (RegexData.regexMaSoSo(maSoXoa)) {
                        for (String[] list : listString1) {
                            if (maSoXoa.equals(list[0])) {
                                System.out.println("Bạn có muốn xóa không (Chọn Y hoặc N)\n" + "1. Yes\n" + "2. No");
                                if ("Y".equals(scanner.nextLine())) {
                                    listString1.remove(list);
                                    isList1 = true;
                                    check = true;
                                } else {
                                    MainControllers.displayMenu();
                                }
                                break;
                            }
                        }
                        if (!isList1) {
                            for (String[] list : listString2) {
                                if (maSoXoa.equals(list[0])) {
                                    System.out.println("Bạn có muốn xóa không (Chọn Y hoặc N)\n" + "1. Yes\n" + "2. No");
                                    if ("Y".equals(scanner.nextLine())) {
                                        listString2.remove(list);
                                        check = true;
                                        break;
                                    } else {
                                        MainControllers.displayMenu();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    if (check && isList1) {
                        System.out.println("Bạn đã xóa thành công");
                        ReadWriteSo.creatFile(ThemSoTietKiem.getFilePath1());
                        for (String[] list : listString1) {
                            String line = String.join(",", list);
                            ReadWriteSo.writeFile(ThemSoTietKiem.getFilePath1(), line);
                        }
                    } else if (check) {
                        System.out.println("Bạn đã xóa thành công");
                        ReadWriteSo.creatFile(ThemSoTietKiem.getFilePath2());
                        for (String[] list : listString2) {
                            String line = String.join(",", list);
                            ReadWriteSo.writeFile(ThemSoTietKiem.getFilePath2(), line);
                        }
                    } else {
                        System.out.println("Mã sản phẩm bạn muốn xóa không có");
                        xoaSoTietKiem();
                    }
                    if (!check) {
                        throw new NotFoundProductException("Sản phẩm không tồn tại");
                    }
                } catch (NotFoundProductException e) {
                    System.out.println(e.getMessage());
                }
            } while (!check);
        }
    }
}
