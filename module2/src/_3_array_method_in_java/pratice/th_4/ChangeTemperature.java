package _3_array_method_in_java.pratice.th_4;


import java.util.Scanner;

public class ChangeTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cel;
        double fah;
        int choice;
        do {
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter youe choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào độ F");
                    fah = scanner.nextDouble();
                    System.out.println(fah + " độ F = " + fahrenheitToCelsius(fah) + " độ C");
                    break;
                case 2:
                    System.out.println("Nhập vào độ C");
                    cel = scanner.nextDouble();
                    System.out.println(cel + " độ C = " + celsiusToFahrenheit(cel) + " độ F");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    public static double fahrenheitToCelsius(double fah) {
        System.out.println("Nhập vào độ F");
        double cel = (5.0 / 9) * (fah - 32);
        return cel;
    }

    public static double celsiusToFahrenheit(double cel) {
        System.out.println("Nhập vào độ C");
        double fah = (9.0 / 5) * cel + 32;
        return fah;
    }
}
