package _15_exception_debug.exercise.bt_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleCheck {
    public static void checkTriangle(float a, float b, float c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Tam giác cạnh phải lớn hơn 0!!!");
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        } else {
            System.out.println("Ba cạnh tạm giác là : " + "\n a = " + a + "\n b = " + b + "\n c = " + c);
        }
    }

    public static void main(String[] args) throws IllegalTriangleException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập cạnh a: ");
                float a = scanner.nextFloat();
                System.out.println("Nhập cạnh b: ");
                float b = scanner.nextFloat();
                System.out.println("Nhập cạnh c: ");
                float c = scanner.nextFloat();
                checkTriangle(a, b, c);
            } catch (InputMismatchException e) {
                System.out.println("nhập sai định dạng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("thanh cong");
        }

    }
}
