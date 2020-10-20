package introduction_to_java.exercise.bt_3;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số USD cần đổi");
        int usd = sc.nextInt();
        int vnd = rate * usd;
        System.out.println(usd + " USD" + " = " + vnd + " VNĐ");
    }
}
