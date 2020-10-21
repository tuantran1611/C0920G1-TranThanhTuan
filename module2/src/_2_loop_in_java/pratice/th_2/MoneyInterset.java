package _2_loop_in_java.pratice.th_2;

import java.util.Scanner;

public class MoneyInterset {
    public static void main(String[] args) {
        double money;
        int month;
        double rate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter interser of amount");
        money = scanner.nextDouble();
        System.out.println("Enter month");
        month = scanner.nextInt();
        System.out.println("Enter rate / year");
        rate = scanner.nextDouble();
        double total = 0;
        for (int i = 0; i < month; i++){
            total += money * (rate/100)/12 * month;
        }
        System.out.println("Total of interset: " + total);
    }
}
