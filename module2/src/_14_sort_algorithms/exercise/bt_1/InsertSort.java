package _14_sort_algorithms.exercise.bt_1;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng");
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++){
            System.out.println("Nhập phần tử: ");
            array[i] = sc.nextInt();
        }
        for (int i = 1 ; i < array.length; i++){
            for (int j = i-1 ; j >= 0; j--){
                if (array[j] > array[j + 1 ]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
