package _3_array_method_in_java.exercise.bt_1;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ: " + (i + 1));
            array[i] = sc.nextInt();
        }
        System.out.print("Danh sách phần tử của mảng là: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập số X cần xóa");
        int x = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
            }
        }
        System.out.print("Danh sách phần tử của mảng sau khi xóa " + x + " là: " + Arrays.toString(array));
    }
}