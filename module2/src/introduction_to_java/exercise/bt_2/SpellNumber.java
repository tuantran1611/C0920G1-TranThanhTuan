package introduction_to_java.exercise.bt_2;

import java.util.Scanner;

public class SpellNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc");
        int num = sc.nextInt();
        switch ((num < 10 & num > 0) ? 1 : (num < 100) ? 2 : 3) {
            case 1:
                System.out.println();
        }
    }
}
