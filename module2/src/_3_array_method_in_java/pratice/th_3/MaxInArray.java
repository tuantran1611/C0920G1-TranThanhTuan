package _3_array_method_in_java.pratice.th_3;

import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
            int size;
            int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng");
            size = scanner.nextInt();
            if (size>20){
                System.out.println("Kích thước mảng phải nhỏ hơn bằng 20");
            }
        } while (size> 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.println("Nhập vào số thứ: " + (i+1));
            array[i] = scanner.nextInt();
        }
        System.out.print("Property list: ");
        for (int i : array) {
            System.out.println(i + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 1; j < array.length; j++){
            if (max < array[j]){
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("Tài sản lớn nhất là: " + max + "\t" + " Ở vị trí thứ: " + index);
    }
}
