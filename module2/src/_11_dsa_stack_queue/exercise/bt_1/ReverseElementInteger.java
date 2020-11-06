package _11_dsa_stack_queue.exercise.bt_1;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseElementInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Integer[] arrays = new Integer[5];
        System.out.println("Nhập phần tử: ");
        for (int i = 0 ; i < arrays.length; i++){
            arrays[i] = sc.nextInt();
        }
        System.out.println("Danh sách mảng: ");
        System.out.println(Arrays.toString(arrays));

        for (Integer array : arrays){
            stack.push(array);
        }
        System.out.println("Danh sách mảng sau khi push: ");
        System.out.println(Arrays.toString(arrays));
        for (int i = 0 ; i < arrays.length; i++){
            arrays[i] = stack.pop();
        }
        System.out.println("Danh sách mảng sau khi pop: ");
        System.out.println(Arrays.toString(arrays));
    }
}