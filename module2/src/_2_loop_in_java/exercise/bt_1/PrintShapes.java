package _2_loop_in_java.exercise.bt_1;

import java.util.Scanner;

public class PrintShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print the isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice");
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("*");
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw square triangle bottom-left");
                    String a = "";
                    for (int i = 0; i < 6; i++) {
                        a += "*";
                        System.out.println(a);
                    }
                    System.out.println("Draw square triangle top-left");
                    for (int j = 6; j >= 1; j--) {
                        for (int k = 1; k <= j; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Draw square triangle top-right");
                    for (int m = 1; m <= 6; m++) {
                        for (int o = 1; o < m; o++) {
                            System.out.print(" ");
                        }
                        for (int n = 6; n >= m; n--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Draw square triangle bottom-right");
                    for (int s = 1; s <= 6; s++) {
                        for (int t = 6; t > s; t-- ){
                            System.out.print(" ");
                        }
                        for (int v = 1; v <= s; v++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Draw isosceles triangle");
                    for (int i = 1; i <= 7; i++ ){
                        for (int j = 7 ; j > i; j--){
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++){
                            System.out.print("*");
                        }
                        for (int m = 1; m < i; m++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice");
                    break;
            }
            System.out.println("Enter your choice");
        }
    }
}
