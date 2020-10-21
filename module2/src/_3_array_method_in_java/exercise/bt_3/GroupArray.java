package _3_array_method_in_java.exercise.bt_3;

import java.util.Scanner;

public class GroupArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1, size2;
        int[] array1;
        int[] array2;
        int[] array3;
        System.out.print("Nhập vào kích thước mảng 1: ");
        size1 = sc.nextInt();
        System.out.print("Nhập vào kích thước mảng 2: ");
        size2 = sc.nextInt();
        array1 = new int[size1];
        array2 = new int[size2];
        array3 = new int[size1 + size2];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Nhập vào số thứ" + (i + 1) + " của mảng 1 : ");
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Nhập vào số thứ" + (i + 1) + " của mảng 2 : ");
            array2[i] = sc.nextInt();
        }
        System.out.print("Danh sách phần tử mảng 1: ");
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Danh sách phần tử mảng 2: ");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Danh sách phần tử mảng 3: ");
        for (int i = 0; i < array1.length; i++) {
                array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
                array3[array1.length + i] = array2[i];
        }
        for (int i : array3) {
            System.out.print(i + " ");
        }
    }
}
