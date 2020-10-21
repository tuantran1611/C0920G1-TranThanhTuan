package _3_array_method_in_java.exercise.bt_1;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;
        int n;
        int x;
        System.out.println("Nhập số lượng phần tử của mảng: ");
        n = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ: " + (i + 1));
            array[i] = sc.nextInt();
        }
        System.out.print("Danh sách phần tử của mảng là: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Nhập số X cần xóa");
        x = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                break;
            }
        }
        System.out.print("Danh sách phần tử của mảng sau khi xóa " + x + " là: ");
        for (int i : array)
            System.out.print(i + " ");
    }
}
