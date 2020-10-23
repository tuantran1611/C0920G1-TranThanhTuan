package _3_array_method_in_java.exercise.bt_3;

import java.util.Arrays;
import java.util.Scanner;

public class GroupArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào kích thước mảng 1: ");
        int[] array1 = new int[sc.nextInt()];
        System.out.print("Nhập vào kích thước mảng 2: ");
        int[] array2 = new int[sc.nextInt()];
        int[] array3 = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Nhập vào số thứ " + (i + 1) + " của mảng 1 : ");
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Nhập vào số thứ " + (i + 1) + " của mảng 2 : ");
            array2[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println();
        System.out.print("Danh sách phần tử mảng 3: ");
        for (int i = 0; i < array3.length; i++) {
            if (i < array1.length){
                array3[i] = array1[i];
            } else {
                array3[i] = array2[i - array1.length];
            }
        }
        System.out.println(Arrays.toString(array3));
    }
}
