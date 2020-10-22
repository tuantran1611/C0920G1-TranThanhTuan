package _3_array_method_in_java.exercise.bt_sao_2;

import java.util.Scanner;

public class SumDiagonalLineInTwoInt {
    public static void displayElementInTwoInt(int[][] array){
        System.out.println("Danh sách mảng 2 chiều");
        for (int row = 0; row < array.length; row++){
            for (int column = 0; column < array[row].length; column++){
                System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[][] array;
        System.out.println("Nhập số hàng và số cột mảng vuông: ");
        size = sc.nextInt();
        array = new int[size][size];
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.println("Nhập phần tử thứ " + (column + 1) + " của hàng thứ " + (row + 1));
                array[row][column] = sc.nextInt();
            }
        }
        displayElementInTwoInt(array);
        int sum = 0;
        for (int row = 0; row < array.length; row++){
            sum += array[row][row];
        }
        System.out.println("Tổng các phần tử của đường chéo chính là: " + sum);
    }
}
