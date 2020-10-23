package _3_array_method_in_java.exercise.bt_5;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementInTwoInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước của mảng: ");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhập phần tử thứ: " + (i + 1));
            arr[i] = sc.nextInt();
        }
        System.out.println("Danh sách mảng: " + Arrays.toString(arr));
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất là: " + min);
    }
}