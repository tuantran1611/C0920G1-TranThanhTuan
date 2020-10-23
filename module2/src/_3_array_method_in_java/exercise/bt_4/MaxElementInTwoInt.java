package _3_array_method_in_java.exercise.bt_4;

import java.util.Scanner;

public class MaxElementInTwoInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        int size1 = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int size2 = sc.nextInt();
        int[][] arr = new int[size1][size2];
        for (int row = 0; row < arr.length; row++) {
            System.out.println("Nhập row: " + (row + 1));
            for (int column = 0; column < arr[row].length; column++) {
                System.out.println("Nhập phần tử thứ: " + (column + 1) + " của row " + (row + 1));
                arr[row][column] = sc.nextInt();
            }
        }
        System.out.println("Danh sách phần tử trong mảng: ");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        int max = arr[0][0];
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Vậy giá trị lớn nhất trong mảng là: " + max + " có tọa độ " + x + "," + y);
    }
}