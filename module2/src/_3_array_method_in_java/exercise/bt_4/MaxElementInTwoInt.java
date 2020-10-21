package _3_array_method_in_java.exercise.bt_4;

import java.util.Scanner;

public class MaxElementInTwoInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        int size;
        System.out.println("Nhập kích thước các phần tử con");
        size = sc.nextInt();
        arr = new int[size][size];
        for (int row = 0; row < arr.length; row++){
            for (int column = 0; column < arr[row].length; column++){
                arr[row][column] = (int) (Math.random()*100);
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
        for (int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Vậy giá trị lớn nhất trong mảng là: " + max + " có tọa độ " + x + "," + y);
    }
}
