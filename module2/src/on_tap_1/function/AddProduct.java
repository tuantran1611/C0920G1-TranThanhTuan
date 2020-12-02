//package on_tap_1.function;
//
//import on_tap_1.commons.ReadWriteFile;
//import on_tap_1.commons.RegexData;
//import on_tap_1.controllers.MainControllers;
//import on_tap_1.models.ProductExport;
//
//import java.util.Scanner;
//
//public class AddProduct {
//    static Scanner scanner = new Scanner(System.in);
//    static int count = 0;
//
//    public static void addProduct(){
//        System.out.println("Chon số chức năng để tiếp tục");
//        System.out.println("1. Add new import product");
//        System.out.println("2. Add new export product");
//        switch (scanner.nextLine()){
//            case "1":
//                addImportProductInfo();
//                MainControllers.displayMenu();
//                break;
//            case "2":
//                addExportProductInfo();
//                MainControllers.displayMenu();
//                break;
//            default:
//                System.out.println("Vui lòng nhập lại");
//                addProduct();
//                break;
//        }
//    }
//
//    public static void addImportProductInfo(){
//        ProductExport product = new ProductExport();
//        count += 1;
//        product.setIdProduct(count);
//        boolean check = false;
//        do {
//            System.out.println("Nhập mã sản phẩm");
//            String productCode = scanner.nextLine();
//            if (RegexData.regexProductCode(productCode)){
//                product.setProductCode(productCode);
//                check = true;
//            } else {
//                System.err.println("Vui lòng nhập đúng định dạng SPXXXXX, XXXXX là 5 số");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập tên sản phẩmm");
//            String productName= scanner.nextLine();
//            if (RegexData.regexProductName(productName)){
//                product.setProductName(productName);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập giá sản phẩmm");
//            String price= scanner.nextLine();
//            if (RegexData.regexPrice(price)){
//                product.setPrice(price);
//                check = true;
//            } else {
//                System.err.println("Giá phải là số dương");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập số lượng");
//            String amount= scanner.nextLine();
//            if (RegexData.regexPrice(amount)){
//                product.setAmount(amount);
//                check = true;
//            } else {
//                System.err.println("Số lượng phải là số dương");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập nhà sản xuất");
//            String producer= scanner.nextLine();
//            if (RegexData.regexProductName(producer)){
//                product.setProducer(producer);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập giá nhập khẩu sản phẩmm");
//            String priceImport= scanner.nextLine();
//            if (RegexData.regexPrice(priceImport)){
//                product.setPriceImport(priceImport);
//                check = true;
//            } else {
//                System.err.println("Giá phải là số dương");
//            }
//        } while (!check);
//
//        check = false;
//        do {
//            System.out.println("Nhập tỉnh nhập khẩu");
//            String provinceImport= scanner.nextLine();
//            if (RegexData.regexProductName(provinceImport)){
//                product.setProvinceImport(provinceImport);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập thuế nhập khẩu sản phẩmm");
//            String taxImport= scanner.nextLine();
//            if (RegexData.regexPrice(taxImport)){
//                product.setTaxImport(taxImport);
//                check = true;
//            } else {
//                System.err.println("Thuế phải là số dương");
//            }
//        } while (!check);
//        String line = product.getIdProduct()+","+product.getProductCode()+","+product.getProductName()+","+
//                product.getPrice()+","+product.getAmount()+","+product.getProducer()+","+product.getPriceImport()+","+
//                product.getProvinceImport()+","+product.getTaxImport();
//        ReadWriteFile.writeFile(line);
//    }
//
//    public static void addExportProductInfo(){
//        ProductExport product = new ProductExport();
//        count += 1;
//        product.setIdProduct(count);
//        boolean check = false;
//        do {
//            System.out.println("Nhập mã sản phẩm");
//            String productCode = scanner.nextLine();
//            if (RegexData.regexProductCode(productCode)){
//                product.setProductCode(productCode);
//                check = true;
//            } else {
//                System.err.println("Vui lòng nhập đúng định dạng SPXXXXX, XXXXX là 5 số");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập tên sản phẩmm");
//            String productName= scanner.nextLine();
//            if (RegexData.regexProductName(productName)){
//                product.setProductName(productName);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập giá sản phẩmm");
//            String price= scanner.nextLine();
//            if (RegexData.regexPrice(price)){
//                product.setPrice(price);
//                check = true;
//            } else {
//                System.err.println("Giá phải là số dương");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập số lượng");
//            String amount= scanner.nextLine();
//            if (RegexData.regexPrice(amount)){
//                product.setAmount(amount);
//                check = true;
//            } else {
//                System.err.println("Số lượng phải là số dương");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập nhà sản xuất");
//            String producer= scanner.nextLine();
//            if (RegexData.regexProductName(producer)){
//                product.setProducer(producer);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//        check = false;
//        do {
//            System.out.println("Nhập giá xuất khẩu sản phẩmm");
//            String priceExport= scanner.nextLine();
//            if (RegexData.regexPrice(priceExport)){
//                product.setPriceExport(priceExport);
//                check = true;
//            } else {
//                System.err.println("Giá phải là số dương");
//            }
//        } while (!check);
//
//        check = false;
//        do {
//            System.out.println("Nhập nước nhập khẩu");
//            String countryEntry= scanner.nextLine();
//            if (RegexData.regexProductName(countryEntry)){
//                product.setCountryEntry(countryEntry);
//                check = true;
//            } else {
//                System.err.println("Chữ đầu tiền phải viết hoa");
//            }
//        } while (!check);
//
//        String line = product.getIdProduct()+","+product.getProductCode()+","+product.getProductName()+","+
//                product.getPrice()+","+product.getAmount()+","+product.getProducer()+","+product.getPriceExport()+","+
//                product.getCountryEntry();
//        ReadWriteFile.writeFile(line);
//    }
//}
