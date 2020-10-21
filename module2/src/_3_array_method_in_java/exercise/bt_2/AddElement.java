package _3_array_method_in_java.exercise.bt_2;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] array;
        int num_add;
        int index;
        System.out.println("Nhập số lượng phần tử trong mảng: ");
        size = sc.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ: " + (i + 1));
            array[i] = sc.nextInt();
        }
        System.out.print("Danh sách phần tử của mảng: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Nhập số muốn chèn");
        num_add = sc.nextInt();
        do {
            System.out.println("Nhập vị trí muốn chèn");
            index = sc.nextInt();
            if (index <= 1 || index >= (array.length - 1)) {
                System.out.println("Không chèn được vào trong mảng");
            }
        } while (index <= 1 || index >= (array.length - 1));
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = num_add;
        System.out.print("Danh sách mảng sau khi thêm " + num_add + " :");
        for (int i: array){
            System.out.print(i + " ");
        }
    }
}
