//package on_tap_1.function;
//
//import case_study_module_2.controllers.MainController;
//import on_tap_1.commons.ReadWriteFile;
//import on_tap_1.commons.RegexData;
//import on_tap_1.controllers.MainControllers;
//import on_tap_2.commons.NotFoundProductException;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class DeleteProduct {
//    static Scanner scanner = new Scanner(System.in);
//
//    public static void deleteProduct() {
//        List<String[]> listString = ReadWriteFile.readFile();
//        boolean check = false;
//        if (listString.isEmpty()) {
//            System.out.println("Danh sách trống");
//        } else {
//            do {
//                System.out.println("Nhập mã sản phẩm muốn xóa");
//                String delProduct = scanner.nextLine();
//                try {
//                    if (RegexData.regexProductCode(delProduct)) {
//                        for (String[] list : listString) {
//                            if (delProduct.equals(list[1])) {
//                                System.out.println("Bạn có muốn xóa không (Chọn Y hoặc N)\n" + "1. Yes\n" + "2. No");
//                                if ("Y".equals(scanner.nextLine())) {
//                                    listString.remove(list);
//                                    check = true;
//                                } else {
//                                    MainControllers.displayMenu();
//                                }
//                                break;
//                            }
//                        }
//                        if (check) {
//                            System.out.println("Bạn đã xóa thành công");
//                            ReadWriteFile.creatFile();
//                            for (String[] list : listString) {
//                                String line = String.join(",", list);
//                                ReadWriteFile.writeFile(line);
//                            }
//                        } else {
//                            System.out.println("Mã sản phẩm bạn muốn xóa không có");
//                            deleteProduct();
//                        }
//                    } else {
//                        throw new NotFoundProductException("Sản phẩm không tồn tại");
//                    }
//                } catch (NotFoundProductException e) {
//                    System.out.println(e.getMessage());
//                }
//            } while (!check);
//        }
//    }
//}
