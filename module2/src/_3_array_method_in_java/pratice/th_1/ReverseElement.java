package _3_array_method_in_java.pratice.th_1;

import java.util.Scanner;

public class ReverseElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập size của array");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("Size của mảng lớn hơn 20 rồi!!!");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length){
            System.out.println("Nhập vào số thứ: " + (i+1));
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for (int j = 0; j < array.length/2; j++){
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size -1 - j] = temp;
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
