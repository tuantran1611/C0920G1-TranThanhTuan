package _12_java_collection_framework.exercise.bt_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager extends Product {
    List<Product> arrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ProductManager() {
    }

    public void addProduct() {
        System.out.println("Nhập ID sản phẩm: ");
        setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        setName(sc.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        setPrice(sc.nextInt());
        Product product = new Product(getId(), getName(), getPrice());
        arrayList.add(product);
        System.out.println("Bạn đã nhập thành công");
        displayMenu();
    }

    public void editProduct() {
        if (arrayList.isEmpty()){
            System.out.println("Danh sách trống, vui lòng nhập lại");
        } else {
            displayListId();
            boolean check = false;
            System.out.println("Nhập ID sản phẩm muốn sửa");
            int idEdit = sc.nextInt();
            sc.nextLine();
            for (Product id : arrayList) {
                if (id.getId() == idEdit) {
                    System.out.println("Tên của sản phẩm muốn sửa: " + id.getName());
                    System.out.println("Nhập tên muốn sửa: ");
                    id.setName(sc.nextLine());
                    check = true;
                    break;
                }
                check = false;
            }
            if (!check) {
                System.out.println("Id sản phẩm bạn muốn sửa không tồn tại, vui lòng nhập lại !!!");
                editProduct();
            } else {
                System.out.println("Bạn đã sửa thành công");
            }
        }
        displayMenu();
    }

    public void deleteProduct() {
        boolean check = false;
        if (arrayList.isEmpty()) {
            System.out.println("Danh sách đang trống");
        } else {
            displayListId();
            System.out.println("Nhập ID sản phẩm muốn xóa");
            int idEdit = sc.nextInt();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId() == idEdit) {
                    arrayList.remove(i);
                    check = true;
                    break;
                }
                check = false;
            }
            if (!check) {
                System.out.println("Id sản phẩm bạn muốn xóa không tồn tại, vui lòng nhập lại !!!");
                deleteProduct();
            } else {
                System.out.println("Bạn đã xóa thành công");
            }
        }
        displayMenu();
    }

    public void displayProduct() {
        if (arrayList.isEmpty()) {
            System.out.println("Danh sách trống, vui lòng nhập lại");
        } else {
            displayListId();
            System.out.println("Nhập ID sau đây để kiểm tra sản phẩm bạn muốn kiểm tra: ");
            int idProduct = sc.nextInt();
            boolean check = false;
            for (Product product : arrayList) {
                if (product.getId() == idProduct) {
                    System.out.println(product);
                    check = true;
                    break;
                }
                check = false;
            }
            if (!check) {
                System.out.println("ID bạn nhập không đúng, vui lòng nhập lại");
                displayProduct();
            }
        }
        displayMenu();
    }

    public void searchProduct() {
        if (arrayList.isEmpty()) {
            System.out.println("Danh sách trống, vui lòng nhập lại");
        } else {
            System.out.println("Nhập tên sản phẩm bạn muốn tìm: ");
            String searchName = sc.nextLine();
            for (Product nameSearch : arrayList) {
                if (nameSearch.getName().equals(searchName)) {
                    System.out.println(nameSearch);
                    break;
                } else {
                    System.out.println("Sản phẩm bạn tìm không tồn tại");
                    searchProduct();
                }
            }
        }
        displayMenu();
    }

    public void sortHightToLow(){
        Collections.sort(arrayList);
        arrayList.sort(new PriceComparator());
        System.out.println(arrayList);
        displayMenu();
    }

    public void sortLowToHight(){
        arrayList.sort(new PriceComparator());
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        displayMenu();
    }

    public void displayListId() {
        System.out.println("Danh sách ID các sản phẩm");
        for (Product id : arrayList) {
            System.out.println(id.getId());
        }
    }

    public void displayMenu() {
        System.out.println("1. Display Product");
        System.out.println("2. Add new Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Search Product");
        System.out.println("6. Exit");
        System.out.println("7. Sort price of product from hight to low");
        System.out.println("8. Sort price of product from low to hight");
        System.out.println("Nhập 1 số: ");
        int choose = sc.nextInt();
        sc.nextLine();
        switch (choose) {
            case 1:
                displayProduct();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                searchProduct();
                break;
            case 6:
                break;
            case 7:
                sortHightToLow();
                break;
            case 8:
                sortLowToHight();
                break;
            default:
                System.out.println("Vui lòng nhập đúng số");
                displayMenu();
                break;
        }
    }
}