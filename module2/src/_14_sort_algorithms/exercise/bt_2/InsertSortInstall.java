package _14_sort_algorithms.exercise.bt_2;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSortInstall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng");
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử: ");
            array[i] = sc.nextInt();
        }
        insertionSort(array);
    }

    public static void insertionSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }
}
