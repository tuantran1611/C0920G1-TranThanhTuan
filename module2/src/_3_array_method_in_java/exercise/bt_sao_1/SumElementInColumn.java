package _3_array_method_in_java.exercise.bt_sao_1;

import _3_array_method_in_java.exercise.bt_sao_2.SumDiagonalLineInTwoInt;

import java.util.Scanner;

public class SumElementInColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int size1 = sc.nextInt();
        System.out.println("Nhập vào số cột: ");
        int size2 = sc.nextInt();
        int[][] array = new int[size1][size2];
        for (int row = 0; row < array.length; row++) {
            System.out.println("Nhập hàng " + (row + 1));
            for (int column = 0; column < array[row].length; column++) {
                System.out.println("Nhập phần tử thứ " + (column + 1) + " của hàng thứ " + (row + 1));
                array[row][column] = sc.nextInt();
            }
        }
        SumDiagonalLineInTwoInt sumDiagonalLineInTwoInt = new SumDiagonalLineInTwoInt();
        sumDiagonalLineInTwoInt.displayElementInTwoInt(array);
        int sum_column;
        do {
            System.out.println("Bạn muốn tính tổng cột thứ mấy: ");
            sum_column = sc.nextInt();
            if (sum_column >= size2 || sum_column < 0) {
                System.out.println("Bạn nhập số thứ cột không đúng");
            }
        } while (sum_column >= size2 || sum_column < 0);
        int sum = 0;
        for (int[] row : array) {
            sum += row[sum_column];
        }
        System.out.println("Tổng các phần tử ở cột thứ " + sum_column + " là: " + sum);
    }
}
