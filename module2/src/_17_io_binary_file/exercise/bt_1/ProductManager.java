package _17_io_binary_file.exercise.bt_1;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    public void productManage(){
        System.out.println("1. Add new Product\n" +
                    "2. Display all Product\n" +
                    "3. Search Product");
        switch (scanner.nextInt()){
            case 1:
                addNewProduct();
                productManage();
                break;
            case 2:
                displayProduct();
                productManage();
                break;
            case 3:
                searchProduct();
                productManage();
                break;
            default:
                System.out.println("Vui lòng nhập lại");
                productManage();
                break;
        }
    }

    public void addNewProduct(){
        Product product = new Product();
        scanner.nextLine();
        System.out.println("Nhập Id sản phẩm: ");
        product.setIdProduct(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        product.setNameProduct(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất: ");
        product.setManufacturer(scanner.nextLine());
        System.out.println("Nhập giá: ");
        product.setPrice(scanner.nextLine());
        System.out.println("Nhập mô tả khác: ");
        product.setOtherDescribe(scanner.nextLine());
        ReadWriteBinaryFile.writeBinaryFile(product);
        System.out.println("Bạn đã nhập thành công");
    }

    public void displayProduct(){
        List<Product> productList= ReadWriteBinaryFile.readBinaryFile();
        System.out.println("fsfsfsfs"+ productList.size());
        for (Product product : productList){
            System.out.println(product.toString());
        }
    }

    public void searchProduct(){
        List<Product> productList= ReadWriteBinaryFile.readBinaryFile();
        boolean check = false;
        displayProduct();
        System.out.println("Nhập ID sản phẩm muốn xem thông tin: ");
        for (Product product : productList){
            if (scanner.nextLine().equals(product.getIdProduct())){
                System.out.println(product.toString());
            }
            check = true;
            break;
        }
        if (check){
            productManage();
        } else {
            System.out.println("ID bạn nhập không đúng, vui lòng nhập lại");
            searchProduct();
        }
    }
}
